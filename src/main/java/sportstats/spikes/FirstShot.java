package sportstats.spikes;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sportstats.db.DbConnectionSingleton;
import sportstats.domain.Leaderboard;
import sportstats.domain.League;
import sportstats.domain.Season;
import sportstats.domain.Sport;
import sportstats.domain.broker.BrokerFactory;
import sportstats.service.AddSportService;
import sportstats.service.GetAllLeaguesBySportIdService;
import sportstats.service.GetAllSportsService;
import sportstats.service.ServiceRunner;
import sportstats.storage.LeagueDao;
import sportstats.storage.SeasonDao;

/**
 * Class used to test the connection of the database via ActiveRecord and DAO-objects.
 *
 * Provides a simple GUI that represents the following tables in the sportstats db:
 * sports, leagues, seasons and leaderboards.
 *
 * Has the CRUD-functionalities, except for Update which has not yet been implemented.
 *
 * @author Niklas
 */
public class FirstShot {
    
    private static LeagueDao leagueDao;
    private static SeasonDao seasonDao;
    
    private static String[][] data;
    private static String[] columnNames;
    
    private static JFrame frame;
    private static JTable table;
    private static DefaultTableModel tableModel;
    
    private static JButton buttonSports;
    private static JButton buttonLeagues;
    private static JButton buttonSeasons;
    private static JButton buttonLeaderboards;
    
    private static String activeTable = "";
    
    private static boolean tableButtonsEnabled = true;
    
    private static final DbConnectionSingleton DB_CONN = DbConnectionSingleton.getInstance();
    private static final BrokerFactory BROKER_FACTORY = new BrokerFactory();
    
    public static void main(String[] args){
        
        //TODO: Check if connected to database
        createGUITest();
        
        
        
        /*
        ServiceRunner<List> serviceRunner = new ServiceRunner(new GetAllLeaguesBySportIdService(17));
        List<League> leagues = serviceRunner.execute();
        
        System.out.println(leagues.size());
        
        for(int i = 0; i < leagues.size(); i++)
            System.out.println(leagues.get(i).getLeagueName());
        */
        
        
        //servicesPrintTest();
        
    }
    
    private static void servicesPrintTest(){
        
        /*
        // GetLeaguesBySportIdService test
        GetAllLeaguesBySportIdService getLeaguesBySportIdService = new GetAllLeaguesBySportIdService(14);
        List<League> leaguesFoundById = new ArrayList<>();
        
        try{
            leaguesFoundById = getLeaguesBySportIdService.execute();
        }catch(InvalidSportIdException e){
            System.out.println("Invalid league id");
        }
        
        for(int i = 0; i < leaguesFoundById.size(); i++)
            System.out.println("league_id:" + leaguesFoundById.get(i).getId() + " league_name:" + leaguesFoundById.get(i).getLeagueName() + " sport_id:" + leaguesFoundById.get(i).getSportId());
        
        // GetSeasonsByLeagueIdService test
        GetAllSeasonsByLeagueIdService getSeasonsByLeagueIdService = new GetAllSeasonsByLeagueIdService(1);
        List<Season> seasonsFoundById = new ArrayList<>();
        
        try{
            seasonsFoundById = getSeasonsByLeagueIdService.execute();
        }catch(InvalidLeagueIdException e){
            System.out.println("Invalid league id");
        }
        
        System.out.println("GetSeasonsByLeagueIdService test");
        
        for(int i = 0; i < seasonsFoundById.size(); i++)
            System.out.println(seasonsFoundById.get(i).getStartYear() + "/" +  seasonsFoundById.get(i).getEndYear());
        */
        
    }
    
    private static void createGUITest(){
        
        frame = new JFrame("title");
        frame.setSize(new Dimension(1200, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        getSportData();
        
        table = new JTable();
        tableModel = new DefaultTableModel(data, columnNames);
        table.setModel(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel mainPanel = new JPanel(new GridBagLayout());
        
        buttonSports = new JButton("sports");
        buttonLeagues = new JButton("leagues");
        buttonSeasons = new JButton("seasons");
        buttonLeaderboards = new JButton("leaderboards");
        
        buttonSports.addActionListener((ActionEvent e) -> {
            getSportData();
            updateTable();
        });
        
        buttonLeagues.addActionListener((ActionEvent e) -> {
            getLeagueData();
            updateTable();
        });
        
        buttonSeasons.addActionListener((ActionEvent e) -> {
            getSeasonData();
            updateTable();
        });
        
        buttonLeaderboards.addActionListener((ActionEvent e) -> {
            getLeaderboardData();
            updateTable();
        });
        
        JButton buttonAdd = new JButton("Add");
        JButton buttonRemove = new JButton("Remove");
        
        buttonAdd.addActionListener((ActionEvent e) -> {
            addRow();
            updateTable();
        });
        
        buttonRemove.addActionListener((ActionEvent e) -> {
            removeSelectedRows();
        });
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 4));
        buttonPanel.add(new JPanel());
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonRemove);
        buttonPanel.add(new JPanel());
        buttonPanel.add(buttonSports);
        buttonPanel.add(buttonLeagues);
        buttonPanel.add(buttonSeasons);
        buttonPanel.add(buttonLeaderboards);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        
        mainPanel.add(scrollPane, gbc);
        gbc.gridy += 2;
        mainPanel.add(buttonPanel, gbc);
        
        frame.add(mainPanel);
        frame.setVisible(true);
        
    }
    
    private static void getSportData(){
        
        toggleDatabaseButtons();
        
        activeTable = "sports";
        frame.setTitle(activeTable);
        
        GetAllSportsService getAllSportsService = new GetAllSportsService();
        ServiceRunner<List> serviceRunner = new ServiceRunner(getAllSportsService);
        
        List<Sport> sports = serviceRunner.execute();
        
        data = new String[sports.size()][Sport.getNumberOfColumns()];
        
        for(int i = 0; i < data.length; i++)
            for(int j = 0; j < data[0].length; j++){
                if(j == 0)
                    data[i][j] = sports.get(i).getId();
                if(j == 1)
                    data[i][j] = sports.get(i).getSportName();
            }
        
        columnNames = Sport.getColumnNames();
        
        toggleDatabaseButtons();
        
    }
    
    private static void getLeaderboardData(){
        
        toggleDatabaseButtons();
        
        activeTable = "leaderboards";
        frame.setTitle(activeTable);
        
        DB_CONN.open();
        List<Leaderboard> leaderboards = Leaderboard.findAll();
        DB_CONN.close();
        
        data = new String[leaderboards.size()][Leaderboard.getNumberOfColumns()];
        
        for(int i = 0; i < data.length; i++)
            for(int j = 0; j < data[0].length; j++){
                if(j == 0)
                    data[i][j] = leaderboards.get(i).getId();
                if(j == 1)
                    data[i][j] = leaderboards.get(i).getSeasonId();
            }
        
        columnNames = Leaderboard.getColumnNames();
        
        toggleDatabaseButtons();
        
    }
    
    private static void getLeagueData(){
        
        toggleDatabaseButtons();
        
        activeTable = "leagues";
        frame.setTitle(activeTable);
        
        leagueDao = new LeagueDao();
        
        League league = new League();
        List<League> leagues = league.getAll();
        
        data = new String[leagues.size()][league.getNumberOfColumns()];
        
        for(int i = 0; i < data.length; i++)
            for(int j = 0; j < data[0].length; j++){
                if(j == 0)
                    data[i][j] = Integer.toString(leagues.get(i).getId());
                if(j == 1)
                    data[i][j] = leagues.get(i).getLeagueName();
                if(j == 2)
                    data[i][j] = Integer.toString(leagues.get(i).getSportId());
            }
        
        columnNames = league.getColumnNames();
        
        toggleDatabaseButtons();
        
    }
    
    private static void getSeasonData(){
        
        toggleDatabaseButtons();
        
        activeTable = "seasons";
        frame.setTitle(activeTable);
        
        seasonDao = new SeasonDao();
        
        List<Season> seasons = seasonDao.getAll();
        
        data = new String[seasons.size()][seasonDao.getNumberOfColumns()];
        
        for(int i = 0; i < data.length; i++)
            for(int j = 0; j < data[0].length; j++){
                if(j == 0)
                    data[i][j] = Integer.toString(seasons.get(i).getId());
                if(j == 1)
                    data[i][j] = Integer.toString(seasons.get(i).getStartYear());
                if(j == 2)
                    data[i][j] = Integer.toString(seasons.get(i).getEndYear());
                if(j == 3)
                    data[i][j] = Integer.toString(seasons.get(i).getLeagueId());
                if(j == 4)
                    data[i][j] = Integer.toString(seasons.get(i).getSeasonTeamMapId());
            }
        
        columnNames = seasonDao.getColumnNames();
        
        toggleDatabaseButtons();
        
    }
    
    public static void addRow(){
        
        switch (activeTable) {
            case "leagues":
                addLeaguePopUp();
                break;
            case "seasons":
                addSeasonPopUp();
                break;
            case "sports":
                addSportPopUp();
                break;
            case "leaderboards":
                addLeaderboardPopUp();
                break;
            default:
                break;
        }
        
    }
    
    public static void removeSelectedRows(){
        
        int[] rows = table.getSelectedRows();
        
        removeSelectedRowsFromDatabase(rows);
        
        for(int i=0;i<rows.length;i++)
            tableModel.removeRow(rows[i]-i);
        
    }
    
    public static void removeSelectedRowsFromDatabase(int[] idsOfRowsToRemoveFromDatabase){
        
        for(int i = 0; i < idsOfRowsToRemoveFromDatabase.length; i++){
            
            int id = Integer.parseInt(tableModel.getValueAt(idsOfRowsToRemoveFromDatabase[i], 0).toString());
            
            switch (activeTable) {
                case "leagues":
                    League leagueToRemoveFromDb = leagueDao.get(id);
                    leagueDao.delete(leagueToRemoveFromDb);
                    break;
                case "seasons":
                    Season seasonToRemoveFromDb = seasonDao.get(id);
                    seasonDao.delete(seasonToRemoveFromDb);
                    break;
                case "sports":
                    DB_CONN.open();
                    Sport sport = Sport.findById(id);
                    sport.delete();
                    DB_CONN.close();
                    break;
                case "leaderboards":
                    DB_CONN.open();
                    Leaderboard leaderboard = Leaderboard.findById(id);
                    leaderboard.delete();
                    DB_CONN.close();
                    break;
                default:
                    break;
            }
            
        }
        
    }
    
    private static void addLeaderboardPopUp(){
        
        seasonDao = new SeasonDao();
        
        List<Season> seasons = seasonDao.getAll();
        
        String[] items = new String[seasons.size()];
        
        for(int i = 0; i < seasons.size(); i++){
            items[i] = Integer.toString(seasons.get(i).getId());
        }
        
        JComboBox<String> combo = new JComboBox<>(items);
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Season id:"));
        panel.add(combo);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Add leaderboard",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            
            DB_CONN.open();
            
            Leaderboard leaderboard = new Leaderboard();
            leaderboard.setSeasonId(combo.getSelectedItem().toString());
            leaderboard.save();
            
            //Update data for GUI
            List<Leaderboard> leaderboards = Leaderboard.findAll();
            
            data = new String[leaderboards.size()][Leaderboard.getNumberOfColumns()];
            
            for(int i = 0; i < data.length; i++)
                for(int j = 0; j < data[0].length; j++){
                    if(j == 0)
                        data[i][j] = leaderboards.get(i).getId();
                    if(j == 1)
                        data[i][j] = leaderboards.get(i).getSeasonId();
                }
            
            DB_CONN.close();
            
        } else {
            
        }
        
        
    }
    
    private static void addSeasonPopUp(){
        
        //TODO: Error handling of input
        
        leagueDao = new LeagueDao();
        
        List<League> leagues = leagueDao.getAll();
        
        String[] items = new String[leagues.size()];
        
        for(int i = 0; i < leagues.size(); i++){
            items[i] = leagues.get(i).getLeagueName();
        }
        
        JComboBox<String> combo = new JComboBox<>(items);
        
        JTextField field1 = new JTextField("");
        JTextField field2 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Start year (int): "));
        panel.add(field1);
        panel.add(new JLabel("End year (int): "));
        panel.add(field2);
        panel.add(new JPanel());
        panel.add(combo);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Add season",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            
            seasonDao = new SeasonDao();
            
            Season season = new Season();
            season.setStartYear(Integer.parseInt(field1.getText()));
            season.setEndYear(Integer.parseInt(field2.getText()));
            
            for(int i = 0; i < leagues.size(); i++){
                if(combo.getSelectedItem().toString().equals(leagues.get(i).getLeagueName())){
                    season.setLeagueId(leagues.get(i).getId());
                }
            }
            
            seasonDao.save(season);
            
            //Update data for GUI
            List<Season> seasons = seasonDao.getAll();
            
            data = new String[seasons.size()][seasonDao.getNumberOfColumns()];
            
            for(int i = 0; i < data.length; i++)
                for(int j = 0; j < data[0].length; j++){
                    if(j == 0)
                        data[i][j] = Integer.toString(seasons.get(i).getId());
                    if(j == 1)
                        data[i][j] = Integer.toString(seasons.get(i).getStartYear());
                    if(j == 2)
                        data[i][j] = Integer.toString(seasons.get(i).getEndYear());
                    if(j == 3)
                        data[i][j] = Integer.toString(seasons.get(i).getLeagueId());
                    if(j == 4)
                        data[i][j] = Integer.toString(seasons.get(i).getSeasonTeamMapId());
                }
            
        } else {
            
        }
        
    }
    
    private static void addLeaguePopUp(){
        
        GetAllSportsService getAllSportsService = new GetAllSportsService();
        ServiceRunner<List> serviceRunner = new ServiceRunner(getAllSportsService);
        
        List<Sport> sports = serviceRunner.execute();
        
        String[] items = new String[sports.size()];
        
        for(int i = 0; i < sports.size(); i++){
            items[i] = sports.get(i).getSportName();
        }
        
        JComboBox<String> combo = new JComboBox<>(items);
        
        JTextField field1 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("League name:"));
        panel.add(field1);
        panel.add(new JPanel());
        panel.add(combo);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Add league",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            
            leagueDao = new LeagueDao();
            
            League league = new League();
            league.setLeagueName(field1.getText());
            
            for(int i = 0; i < sports.size(); i++){
                if(combo.getSelectedItem().toString().equals(sports.get(i).getSportName())){
                    league.setSportId(Integer.parseInt(sports.get(i).getId()));
                }
            }
            
            leagueDao.save(league);
            
            //Update data for GUI
            List<League> leagues = leagueDao.getAll();
            
            data = new String[leagues.size()][leagueDao.getNumberOfColumns()];
            
            for(int i = 0; i < data.length; i++)
                for(int j = 0; j < data[0].length; j++){
                    if(j == 0)
                        data[i][j] = Integer.toString(leagues.get(i).getId());
                    if(j == 1)
                        data[i][j] = leagues.get(i).getLeagueName();
                    if(j == 2)
                        data[i][j] = Integer.toString(leagues.get(i).getSportId());
                }
            
        } else {
            
        }
        
    }
    
    private static void addSportPopUp(){
        
        JTextField field1 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Sport name:"));
        panel.add(field1);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Add sport",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            
            String sportName = field1.getText();
            
            AddSportService addSportService = new AddSportService(sportName);
            ServiceRunner<Sport> serviceRunner1 = new ServiceRunner(addSportService);
            serviceRunner1.execute();
            
            //Update data for GUI
            GetAllSportsService getAllSportsService = new GetAllSportsService();
            ServiceRunner<List> serviceRunner2 = new ServiceRunner(getAllSportsService);
            List<Sport> sports = serviceRunner2.execute();
            
            data = new String[sports.size()][Sport.getNumberOfColumns()];
            
            for(int i = 0; i < data.length; i++)
                for(int j = 0; j < data[0].length; j++){
                    if(j == 0)
                        data[i][j] = sports.get(i).getId();
                    if(j == 1)
                        data[i][j] = sports.get(i).getSportName();
                }
            
        } else {
            
        }
        
    }
    
    private static void updateTable(){
        tableModel.setDataVector(data, columnNames);
        tableModel.fireTableDataChanged();
    }
    
    private static void toggleDatabaseButtons(){
        
        tableButtonsEnabled = !tableButtonsEnabled;
        
        if(buttonSports != null){
            buttonSports.setEnabled(tableButtonsEnabled);
            buttonLeagues.setEnabled(tableButtonsEnabled);
            buttonSeasons.setEnabled(tableButtonsEnabled);
            buttonLeaderboards.setEnabled(tableButtonsEnabled);
        }
        
    }

}
