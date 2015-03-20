/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class StaticsticsTest {
    
    Statistics stats;
    Reader readerStub = new Reader() {

        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    public StaticsticsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void jokaisenPelaajanJoukkueEdmonton() {
        Statistics stats1 = new Statistics(readerStub);
        List oilers = new ArrayList<Player>();
      
        oilers = stats1.team("EDM");
        
        Player player1 = (Player)oilers.get(0);
        Player player2 = (Player)oilers.get(0);
        Player player3 = (Player)oilers.get(0);
        
        assertTrue(player1.getTeam().equals("EDM"));
        assertTrue(player2.getTeam().equals("EDM"));
        assertTrue(player3.getTeam().equals("EDM"));
    }
    @Test
    public void ketaanEiLisataJoukkueenPerusteella(){
        Statistics stats1 = new Statistics(readerStub);
        List bolts = new ArrayList<Player>();
        bolts = stats1.team("TBL");
        
        assertTrue(bolts.isEmpty());
        
    }
    
    @Test
    public void oikeaPelaajaPalautuu(){
        Statistics stats1 = new Statistics(readerStub);
        Player player = stats1.search("Kurri");
        Player kurri = (Player)readerStub.getPlayers().get(2);
        
        assertTrue(player.getName().equals("Kurri"));
        assertTrue(player.compareTo(kurri) == 0);
    }
    
    @Test
    public void oikeaPelaajaPalautuu2(){     
        Statistics stats1 = new Statistics(readerStub);
        Player player = stats1.search("Gre");
        
        assertTrue(player.getName().equals("Gretzky"));
        assertTrue(player.getAssists() == 89);
        assertTrue(player.getGoals() == 35);
        assertTrue(player.getName().contains ("Gre"));
        assertFalse(player.getName().equals("Kurri"));
        assertFalse(player == null);
        
    }
    
    @Test
    public void palaajaaEiLoydy(){
        Statistics stats1 = new Statistics(readerStub);
        Player player = stats1.search("Stamkos");
        
        assertTrue(player == null);
    }
    
    @Test
    public void topScorersOikein(){
        Statistics stats1 = new Statistics(readerStub);
        List topPlayers;
        topPlayers = stats1.topScorers(2);
        
        assertTrue(topPlayers.size() == 3);
        
    }
    
    @Test
    public void topScorersOikein2(){
        Statistics stats1 = new Statistics(readerStub);
        List topPlayers;
        topPlayers = stats1.topScorers(0);
        
        Player best = (Player)topPlayers.get(0);
        
        assertTrue(best.getPoints() == 124);
        assertTrue(best.getGoals() == 35);
        assertFalse(best.getGoals() == 45);
        assertTrue(best.getAssists() == 89);
        assertFalse(best.getAssists() == 54);
        assertTrue(topPlayers.size() == 1);
        
    }
    
}