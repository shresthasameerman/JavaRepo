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

class Game{
    public void start()
    {
        System.out.println("game started");
    }
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