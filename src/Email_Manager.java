import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * Thread-safe email manager with validation and common operations.
 */
public class Email_Manager {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    // Thread-safe set backed by a ConcurrentHashMap
    private final Set<String> emailAddresses =
            Collections.newSetFromMap(new ConcurrentHashMap<>());

    /**
     * Adds an email address after validation.
     * @param email non-null email string
     * @return true if the address was added (was not already present)
     * @throws IllegalArgumentException if email is null or invalid
     */
    public boolean addEmail(String email) {
        if (email == null) throw new IllegalArgumentException("email must not be null");
        String normalized = normalize(email);
        if (!isValidEmail(normalized)) throw new IllegalArgumentException("invalid email: " + email);
        return emailAddresses.add(normalized);
    }

    /**
     * Removes an email address.
     * @param email email to remove
     * @return true if the address was removed
     */
    public boolean removeEmail(String email) {
        if (email == null) return false;
        return emailAddresses.remove(normalize(email));
    }

    /**
     * Checks if an email exists.
     * @param email to check
     * @return true if known
     */
    public boolean exists(String email) {
        if (email == null) return false;
        return emailAddresses.contains(normalize(email));
    }

    /**
     * Returns an unmodifiable snapshot of known emails.
     * @return unmodifiable set
     */
    public Set<String> getAllEmails() {
        return Collections.unmodifiableSet(new HashSet<>(emailAddresses));
    }

    /**
     * Number of stored emails.
     */
    public int size() {
        return emailAddresses.size();
    }

    /**
     * Clears all stored emails.
     */
    public void clear() {
        emailAddresses.clear();
    }

    private static String normalize(String email) {
        return email.trim().toLowerCase(Locale.ROOT);
    }

    private static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    // Simple main for demonstration and manual testing
    public static void main(String[] args) {
        Email_Manager m = new Email_Manager();
        System.out.println("add alice@example.com: " + m.addEmail("alice@example.com"));
        System.out.println("add ALICE@EXAMPLE.COM (normalized duplicate): " + m.addEmail("ALICE@EXAMPLE.COM"));
        System.out.println("exists alice@example.com: " + m.exists("alice@example.com"));
        System.out.println("size: " + m.size());
        System.out.println("all emails: " + m.getAllEmails());
    }
}