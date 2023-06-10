package org.example.gui;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.example.model.game.entities.Player;
import org.example.model.Position;
import org.example.model.game.Attacks.Attack;
import org.example.model.game.Pokemons.Pokemon;
import org.example.model.game.Terrain.Bush;
import org.example.model.game.Terrain.Rock;
import org.example.utilities.TestPair;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class LanternaGUI implements GUI {
    private final Screen screen;
    private final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '>', '<', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',' '};
    private HashMap<String,String> type2color= new HashMap<>();
    private final Map<Character, boolean[][]> alphamap = new HashMap<>();
    private boolean wind=true;
    public LanternaGUI(Screen screen) throws URISyntaxException, FileNotFoundException {
        this.screen = screen;

        URL resourceAlphabet = getClass().getResource("/alphabet.txt");
        File file = new File(resourceAlphabet.toURI());
        Scanner alphaReader = new Scanner(file);

        int letter = 0;
        while(alphaReader.hasNextLine()) {
            boolean[][] next = new boolean[5][5];
            for(int i = 0; i < 5; i++) {
                String l = alphaReader.nextLine();
                for(int j = 0; j < 5; j++) {
                    next[i][j] = l.charAt(j) == '#';
                }
            } alphamap.put(alphabet[letter++], next);
        }
    }
    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException{
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);

        URL resourceAlphabet = getClass().getResource("/alphabet.txt");
        File file = new File(resourceAlphabet.toURI());
        Scanner alphaReader = new Scanner(file);

        int letter = 0;
        while(alphaReader.hasNextLine()) {
            boolean[][] next = new boolean[5][5];
            for(int i = 0; i < 5; i++) {
                String l = alphaReader.nextLine();
                for(int j = 0; j < 5; j++) {
                    next[i][j] = l.charAt(j) == '#';
                }
            } alphamap.put(alphabet[letter++], next);
        }
        type2color.put("Normal","#000000");
        type2color.put("Grass","#00FF00");
        type2color.put("Water","#0000FF");
        type2color.put("Fire","#FFA500");
        type2color.put("Electric","#FFFF00");
        type2color.put("Rock","#964B00");
    }
    private Screen createScreen(Terminal terminal) throws IOException{
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }
    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException{
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }
    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException{
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        DefaultTerminalFactory factory = new DefaultTerminalFactory();

        Font loadedFont = font.deriveFont(Font.PLAIN, 5);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'p') return ACTION.POKEDEX;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'i') return ACTION.INVENTORY;
        return ACTION.NONE;
    }
    @Override
    public void drawPlayer(Player player) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.fillRectangle(new TerminalPosition(player.getPosition().get_x(), player.getPosition().get_y()),new TerminalSize(5,1),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0000FF"));
        graphics.fillRectangle(new TerminalPosition(player.getPosition().get_x(), player.getPosition().get_y()+1),new TerminalSize(5,1),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.setCharacter(player.getPosition().get_x()+2,player.getPosition().get_y(),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(player.getPosition().get_x(), player.getPosition().get_y()+2),new TerminalSize(5,3),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(player.getPosition().get_x()+1, player.getPosition().get_y()+2),new TerminalSize(1,2),' ');
        graphics.fillRectangle(new TerminalPosition(player.getPosition().get_x()+3, player.getPosition().get_y()+2),new TerminalSize(1,2),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString(type2color.get(player.getPokemon(player.getPokemonchoice()).getType())));
        graphics.fillRectangle(new TerminalPosition(player.getLastPosition().get_x(),player.getLastPosition().get_y()),new TerminalSize(5,5),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(player.getLastPosition().get_x()+1, player.getLastPosition().get_y()+1),new TerminalSize(1,2),' ');
        graphics.fillRectangle(new TerminalPosition(player.getLastPosition().get_x()+3, player.getLastPosition().get_y()+1),new TerminalSize(1,2),' ');
        graphics.fillRectangle(new TerminalPosition(player.getLastPosition().get_x()+1,player.getLastPosition().get_y()+4),new TerminalSize(3,1),' ');
    }
    @Override
    public void drawBush(Position position, Bush bush) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#00A300"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.fillRectangle(new TerminalPosition(position.get_x()+1, position.get_y()), new TerminalSize(3,1),' ');
        graphics.fillRectangle(new TerminalPosition(position.get_x(), position.get_y()+1), new TerminalSize(5,4),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#006400"));
        for(TestPair pixels:bush.getPixels()){
            graphics.setCharacter(position.get_x()+pixels.getI(), position.get_y()+ pixels.getJ()+1,' ' );
        }
    }
    @Override
    public void drawRock(Position position, Rock rock) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#E28743"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.fillRectangle(new TerminalPosition(position.get_x(), position.get_y()), new TerminalSize(5,5),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#873E23"));
        for(TestPair pixel:rock.getPixels()){
            graphics.setCharacter(position.get_x()+pixel.getI(),position.get_y()+pixel.getJ(), ' ' );
        }
    }
    @Override
    public void drawTallGrass(Position position) {
        Random random=new Random();
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#013220"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.fillRectangle(new TerminalPosition(position.get_x(), position.get_y()+2), new TerminalSize(5,3),' ');
        wind= random.nextBoolean();
        if(wind){
            graphics.setCharacter(position.get_x(), position.get_y()+1, ' ');
            graphics.setCharacter(position.get_x()+2, position.get_y()+1, ' ');
            graphics.setCharacter(position.get_x()+4, position.get_y()+1, ' ');
        }else{
            graphics.setCharacter(position.get_x()+1, position.get_y()+1, ' ');
            graphics.setCharacter(position.get_x()+3, position.get_y()+1, ' ');
        }

    }
    @Override
    public void drawWater(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#44A6C6"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#4465C6"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.fillRectangle(new TerminalPosition(position.get_x(), position.get_y()), new TerminalSize(5,5),'~');
    }
    @Override
    public void drawPotion(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#808080"));
        graphics.fillRectangle(new TerminalPosition(position.get_x()+1, position.get_y()), new TerminalSize(3,5),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#CC8899"));
        graphics.fillRectangle(new TerminalPosition(position.get_x()+2, position.get_y()+1), new TerminalSize(1,3),' ');
    }
    @Override
    public void drawPokeball(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.fillRectangle(new TerminalPosition(position.get_x()+1, position.get_y()), new TerminalSize(3,1),' ');
        graphics.fillRectangle(new TerminalPosition(position.get_x(), position.get_y()+1), new TerminalSize(5,2),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(position.get_x(), position.get_y()+3), new TerminalSize(5,1),' ');
        graphics.fillRectangle(new TerminalPosition(position.get_x()+1, position.get_y()+4), new TerminalSize(3,1),' ');
    }
    @Override
    public void drawGround(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#90EE90"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.setForegroundColor(TextColor.Factory.fromString("#A1FFA1"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(150, 150), 'W');
    }
    @Override
    public void drawText(String s, int x, int y,String color) {
        for(int i = 1; i <= s.length(); i++) {
            boolean[][] currentc = alphamap.get(s.charAt(i - 1));
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(currentc[j][k]) {
                        screen.setCharacter(x + k + i * 6, y + j, new TextCharacter(' ').withBackgroundColor(TextColor.Factory.fromString(color)));
                    }
                }
            }
        }
    }
    @Override
    public void drawMenuText(int i) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(150, 150), ' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        switch (i){
            case 0:{
                drawText("<",100,50,"#000000");
                break;
            }
            case 1:{
                drawText("<",100,60,"#000000");
                break;
            }
            case 2:{
                drawText("<",100,70,"#000000");
                break;
            }
        }
        drawText("start",58,50,"#000000");
        drawText("help",58,60,"#000000");
        drawText("exit",58,70,"#000000");
        drawText("pokemon",54,30,"#0000FF");
        drawText("pokemon",56,30,"#0000FF");
        drawText("pokemon",55,29,"#0000FF");
        drawText("pokemon",55,31,"#0000FF");
        drawText("pokemon",55,30,"#FFFF00");
    }
    @Override
    public void drawBattleMenu(int i,int j,boolean x,Pokemon playerpokemon, Pokemon opponent) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(150, 150),' ');
        String color;
        if(x){
            int pos = 6;
            for(Attack attack: playerpokemon.getattacks()){
                drawText(attack.getName(),6,pos,type2color.get(attack.getType()));
                pos+=10;
            }
            drawText(">",0,6+j*10,"#000000");
        }else{
            graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
            switch (i){
                case 0:{
                    graphics.fillRectangle(new TerminalPosition(1+5, 139), new TerminalSize(32+5, 7),' ');
                    break;
                }
                case 1:{
                    graphics.fillRectangle(new TerminalPosition(49+6, 139), new TerminalSize(37+6, 7),' ');
                    break;
                }
                case 2:{
                    graphics.fillRectangle(new TerminalPosition(99+6, 139), new TerminalSize(17+2, 7),' ');
                    break;
                }
            }
            drawText("attack",1,140,"#000000");
            drawText("capture",50,140,"#000000");
            drawText("run",100,140,"#000000");
            drawText(playerpokemon.getName(),0,60,type2color.get(playerpokemon.getType()));
            drawText(String.valueOf(playerpokemon.getHP()),100,60,"#000000");
            drawText("hp",120,60,"#000000");
            drawText(opponent.getName(),0,80,type2color.get(opponent.getType()));
            drawText(String.valueOf(opponent.getHP()),100,80,"#000000");
            drawText("hp",120,80,"#000000");
        }

    }
    @Override
    public void drawTrainerBattleMenu(int i,int j,boolean x,Pokemon playerpokemon, Pokemon opponent) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(150, 150),' ');
        String color;
        if(x){
            int pos = 6;
            for(Attack attack: playerpokemon.getattacks()){
                drawText(attack.getName(),6,pos,type2color.get(attack.getType()));
                pos+=10;
            }
            drawText(">",0,6+j*10,"#000000");
        }else{
            graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
            switch (i){
                case 0:{
                    graphics.fillRectangle(new TerminalPosition(1+5, 139), new TerminalSize(32+5, 7),' ');
                    break;
                }
                case 1:{
                    graphics.fillRectangle(new TerminalPosition(49+6, 139), new TerminalSize(37+6, 7),' ');
                    break;
                }
            }
            drawText("attack",1,140,"#000000");
            drawText("pokedex",50,140,"#000000");
            drawText(playerpokemon.getName(),0,60,type2color.get(playerpokemon.getType()));
            drawText(String.valueOf(playerpokemon.getHP()),100,60,"#000000");
            drawText("hp",120,60,"#000000");
            drawText(opponent.getName(),0,80,type2color.get(opponent.getType()));
            drawText(String.valueOf(opponent.getHP()),100,80,"#000000");
            drawText("hp",120,80,"#000000");
        }

    }
    @Override
    public void drawPokedex(Player player,int j) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(150, 150),' ');
        int i=10;
        for(Pokemon pokemon: player.getPokedex()){
            drawText(pokemon.getName(), 10,i,type2color.get(pokemon.getType()));
            drawText(String.valueOf(pokemon.getHP()),100,i,"#000000");
            drawText("hp",120,i,"#000000");
            i+=10;
        }
        drawText(">",0,(j+1)*10,"#000000");
    }
    @Override
    public void drawStats(Pokemon pokemon,boolean choice) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(150, 150),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        if(!choice){
            graphics.fillRectangle(new TerminalPosition(15,139),new TerminalSize(25,7),' ');
        }else{
            graphics.fillRectangle(new TerminalPosition(80,139),new TerminalSize(37,7),' ');
        }
        drawText(pokemon.getName(),5, 10,type2color.get(pokemon.getType()));
        drawText(String.valueOf(pokemon.getLVL()),10,20 ,"#000000");
        drawText("lvl",22,20 ,"#000000");
        drawText(String.valueOf(pokemon.getHP()),10,30 ,"#000000");
        drawText("hp",22,30 ,"#000000");
        drawText(String.valueOf(pokemon.getATK()),10,40 ,"#000000");
        drawText("atk",22, 40,"#000000");
        drawText(String.valueOf(pokemon.getDEF()),10,50 ,"#000000");
        drawText("def",22,50 ,"#000000");
        drawText(String.valueOf(pokemon.getSPD()),10,60 ,"#000000");
        drawText("spd",22,60 ,"#000000");
        drawText("attacks",5,70,"#000000");
        int y=80;
        for(Attack attack:pokemon.getattacks()){
            drawText(attack.getName(),10,y,type2color.get(attack.getType()));
            y+=10;
        }
        drawText("quit",10,140,"#000000");
        drawText("choose",75,140,"#000000");
    }
    @Override
    public void drawInventory(Player player) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(150, 150),' ');
        drawText("potions",10,10,"#000000");
        drawText(String.valueOf(player.PotionAmount()),100,10,"#000000");
        drawText("pokeballs",10,30,"#000000");
        drawText(String.valueOf(player.PokeballAmount()),100,30,"#000000");
    }
    @Override
    public void drawEnemyTrainer(Position position){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.fillRectangle(new TerminalPosition(position.get_x(), position.get_y()),new TerminalSize(5,1),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0000FF"));
        graphics.fillRectangle(new TerminalPosition(position.get_x(), position.get_y()+1),new TerminalSize(5,1),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.setCharacter(position.get_x()+2,position.get_y(),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(position.get_x(), position.get_y()+2),new TerminalSize(5,3),' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(position.get_x()+1, position.get_y()+2),new TerminalSize(1,2),' ');
        graphics.fillRectangle(new TerminalPosition(position.get_x()+3, position.get_y()+2),new TerminalSize(1,2),' ');
    }
    @Override
    public void clear() {
        screen.clear();
    }
    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }
    @Override
    public void close() throws IOException {
        screen.close();
    }
}
