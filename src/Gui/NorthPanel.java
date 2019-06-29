package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * This class is for showing northPanel
 * This class include menubar,search bar and
 * also the name of the user.
 * @author Mohammad tavakoli & Amir saadatmand
 *
 */
public class NorthPanel extends JPanel
{
    static String name;
    private UndoManager undoManager = new UndoManager();
    private JMenu fileMenu ;
    private JMenuItem helpMenuItem;
    private JMenuItem exitMenuItem;
    private JButton undoButton ;
    private JButton redoButton ;
    private JButton searchButton;
    private JTextField searchField ;
    private JPanel controlpanel ;
    private JPanel innerPanel;
    private JPanel eastPanel ;
    private JLabel namebar;
    private JMenuBar menuBar;
    private JPanel inpanel;

    /**
     *
     * constructor for NorthPanel class
     */
    public NorthPanel()
    {

        super();
        setOpaque(true);
        setBackground(Color.black);
        setLayout(new BorderLayout());

        Image filseMenu = null;
        try {
            filseMenu = ImageIO.read(getClass().getResource("Icons//menu2.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image undo = null;

        try {
            undo = ImageIO.read(getClass().getResource("Icons//undo.png")).getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image redo = null;

        try {
            redo = ImageIO.read(getClass().getResource("Icons//redo.png")).getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image browse = null;
        try {
            browse = ImageIO.read(getClass().getResource("Icons//Browse.png")).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        searchField = new JTextField();
        searchField.setLayout(new FlowLayout());
        searchField.setColumns(10);
        searchField.setEditable(true);
        searchField.setFont(new Font("Italic",Font.BOLD,12));

        undoButton = new MyButton("",Color.BLACK,"Undo",undo);
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(undoManager.canUndo()){
                    undoManager.undo();
                }
            }
        });
        redoButton = new MyButton("",Color.BLACK,"Redo",redo);
        redoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(undoManager.canRedo()){
                    undoManager.redo();
                }
            }
        });
        fileMenu   = new JMenu();
        fileMenu.setIcon(new ImageIcon(filseMenu));
        fileMenu.setContentAreaFilled(false);
        fileMenu.setBorderPainted(false);
        fileMenu.setFocusPainted(false);
        fileMenu.setOpaque(true);
        fileMenu.setBackground(Color.black);


        helpMenuItem= new JMenuItem("Help");
        exitMenuItem =new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        fileMenu.add(helpMenuItem);
        fileMenu.add(exitMenuItem);

        menuBar=new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.gray);
        menuBar.add(fileMenu);

        controlpanel = new JPanel();
        innerPanel = new JPanel();
        eastPanel = new JPanel();
        namebar = new JLabel("          " +name);
        searchButton = new MyButton("Search",Color.BLACK,"search",browse);



        Border border = BorderFactory.createLineBorder(Color.yellow, 2);


        namebar.setFont(new Font("Italic",Font.BOLD,20));
        namebar.setForeground(Color.darkGray);
        namebar.setPreferredSize(new Dimension(200,30));

        searchField.setFont(new Font("Italic",Font.BOLD,20));
        searchField.setColumns(25);
        searchField.setEditable(true);
        searchField.setForeground(Color.white);
        searchField.setBorder(null);
        searchField.setBackground(Color.gray);
        searchField.setBorder(border);





        innerPanel.setLayout(new WrapLayout(WrapLayout.RIGHT));
        innerPanel.setOpaque(true);
        innerPanel.setBackground(Color.black);
        innerPanel.add(undoButton);
        innerPanel.add(redoButton);
        innerPanel.add(searchButton);

        inpanel = new JPanel();
        inpanel.setLayout(new GridLayout(1,2));
        inpanel.setOpaque(true);
        inpanel.setBackground(Color.black);

        controlpanel.setOpaque(true);
        controlpanel.setBackground(Color.black);
        controlpanel.setLayout(new BorderLayout());
        controlpanel.add(innerPanel,BorderLayout.WEST);
        controlpanel.add(new JLabel("                         "),BorderLayout.CENTER);
        controlpanel.add(inpanel,BorderLayout.EAST);

        add(menuBar,BorderLayout.WEST);
        add(controlpanel,BorderLayout.CENTER);
        add(namebar,BorderLayout.EAST);

    }

    /**
     * setName of the user
     *
     * @return void
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * getController panel
     *
     * @return JPanel
     */
    public JPanel getControlpanel() {
        return controlpanel;
    }

    /**
     * get InnerPanel
     *
     * @return JPanel
     */
    public JPanel getInnerPanel() {
        return innerPanel;
    }

    /**
     * get EastPanel
     *
     * @return JPanel
     */
    public JPanel getEastPanel() {
        return eastPanel;
    }

    /**
     * setName of the user
     *
     * @return UndoManager
     */
    public UndoManager getUndoManager() {
        return undoManager;
    }

    /**
     * get FielMenu
     *
     * @return JMenu
     */
    public JMenu getFileMenu() {
        return fileMenu;
    }

    /**
     * get UndoButton
     *
     * @return JButton
     */
    public JButton getUndoButton() {
        return undoButton;
    }

    /**
     * get RedoButton
     *
     * @return JButton
     */
    public JButton getRedoButton() {
        return redoButton;
    }

    /**
     * get SearchButton
     *
     * @return JButton
     */
    public JButton getSearchButton() {
        return searchButton;
    }

    /**
     * get searchField
     *
     * @return JTextField
     */
    public JTextField getSearchField() {
        return searchField;
    }

    /**
     * get Namebar
     *
     * @return JLabel
     */
    public JLabel getNamebar() {
        return namebar;
    }
}
