//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pubg game = new Pubg();
        COD codGame = new COD();
        ClashOfClans cocGame = new ClashOfClans();
        game.start();
        game.stop();
        codGame.start();
        cocGame.start();

    }
}
interface Play
{
    public void start();
    public void stop();
}

class Pubg implements Play
{
    @Override
    public void start() {
        System.out.println("hello world!");
    }
    @Override
    public void stop() {
        System.out.println("hello world!");
    }
}

abstract  class Game{
    abstract public void start();
}

class COD extends Game
{
    @Override
    public void start() {
        System.out.println("COD game started");
    }
}

class ClashOfClans extends Game
{
    @Override
    public void start() {
        System.out.println("Clash of clans game started");
    }
}

/*
  Below are additional classes that demonstrate abstract-class usage
  without modifying the existing code above.

  Two examples are provided:
  1) MobileGame - an abstract class that implements the Play interface.
     It provides a concrete start() and leaves stop() abstract so
     subclasses must implement stop(). It also has an abstract update()
     method to show additional abstract behavior.

  2) ShootingGame - an abstract class that extends the existing abstract
     Game class to show how to add shared behavior for concrete games
     that extend Game.

  ExampleRunner (non-public) contains a main method that demonstrates
  creating the new concrete subclasses and calling their methods.
  You don't need to change the original Main class; run ExampleRunner to
  see the abstract-class examples in action.
*/

abstract class MobileGame implements Play {
    // Provide a default start implementation that subclasses can reuse or override
    @Override
    public void start() {
        System.out.println("MobileGame default start");
    }

    // Force subclasses to implement stop()
    @Override
    public abstract void stop();

    // Additional abstract behavior specific to mobile games
    public abstract void update();

    // A concrete helper method
    public void info() {
        System.out.println("MobileGame: base class for mobile games");
    }
}

// Concrete subclass of MobileGame
class TempleRun extends MobileGame {
    @Override
    public void stop() {
        System.out.println("TempleRun stopped");
    }

    @Override
    public void update() {
        System.out.println("TempleRun updated");
    }

    // Optionally override start to extend the base behavior
    @Override
    public void start() {
        super.start();
        System.out.println("TempleRun custom start");
    }
}

// Abstract class extending the existing abstract Game class
abstract class ShootingGame extends Game {
    // Shared concrete method for shooting games
    public void commonFeature() {
        System.out.println("ShootingGame: common feature applied");
    }

    // keep start() abstract (inherited) so concrete shooting games must implement it
}

// Concrete subclass of ShootingGame
class Valorant extends ShootingGame {
    @Override
    public void start() {
        commonFeature();
        System.out.println("Valorant started");
    }
}

// A small runner to demonstrate the added abstract-class examples.
// This is a separate (non-public) class with its own main so the original
// Main class remains unchanged.
class ExampleRunner {
    public static void main(String[] args) {
        System.out.println("=== MobileGame example ===");
        TempleRun tr = new TempleRun();
        tr.info();
        tr.start();
        tr.update();
        tr.stop();

        System.out.println("\n=== ShootingGame example ===");
        Valorant v = new Valorant();
        v.start();
    }
}