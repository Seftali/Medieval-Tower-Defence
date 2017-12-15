package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class InformationPanel extends javax.swing.JPanel {
    
    int selectedUnitType;
    int selectedSpecUnit;
    String unitLabel;
	BufferedImage backgroundImage;
	String imageBuffer = "/images/gui/information.jpg";
    /**
     * Creates new form InfoPanel
     */
    public InformationPanel() {
        unitLabel = " ";
        selectedUnitType = 1;
        selectedSpecUnit = 0;
		this.setPreferredSize(new Dimension(832,776));
	     try {
	         backgroundImage = ImageIO.read(getClass().getResourceAsStream(imageBuffer));
	        } catch(IOException exc) {
	          exc.printStackTrace();
	        }
       initComponents();
   }
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, null);
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        unitTypeComboBox = new javax.swing.JComboBox<>();
        backBut = new javax.swing.JButton();
        enemyComboBox = new javax.swing.JComboBox<>();
        enemyComboBox.setVisible(false);
        towerComboBox = new javax.swing.JComboBox<>();
        unitLabelText = new javax.swing.JLabel();

        unitTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tower", "Enemy" }));
        unitTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitTypeComboBoxActionPerformed(evt);
            }
        });

        backBut.setText("Back");
        backBut.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		backButActionPerformed(evt);
        	}
        });
        enemyComboBox.setMaximumRowCount(17);
        enemyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Death knight", "Demon", "Dragon", "Dwarven Demolishers", "Elven Archer", "Flying Machine", "Footman", 
        																			 "Goblins", 	 "Grunt", "GryphonRider", "Knight", "Mage", "Ogre", "Peasant", "Peon", "Skeleton", "Troll" }));
        enemyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enemyComboBoxActionPerformed(evt);
            }
        });

        towerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arcane Tower", "Arrow Tower", "Balista Tower", "Cannon Tower", "Ice Tower", "Mortar Tower", "Oil Tower", "Poison Tower" }));
        towerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towerComboBoxActionPerformed(evt);
            }
        });

        unitLabelText.setBackground(new java.awt.Color(0, 0, 0));
        unitLabelText.setForeground(new java.awt.Color(0, 0, 0));
        unitLabelText.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        unitLabelText.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(backBut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(467, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(unitLabelText, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(unitTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(enemyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                            .addComponent(towerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(unitTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enemyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(towerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(unitLabelText, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(backBut)
                .addGap(89, 89, 89))
        );
    }// </editor-fold>                        
    private void backButActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	this.hide();
    	GameFrame settingsTriggered = new GameFrame(new MainMenuPanel());
    }   
    private void unitTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
            selectedUnitType = unitTypeComboBox.getSelectedIndex();
            if(selectedUnitType == 0){
                enemyComboBox.setVisible(false);
                towerComboBox.setVisible(true);
            }
            if(selectedUnitType == 1){
                enemyComboBox.setVisible(true);
                towerComboBox.setVisible(false);
            }
    }                                                

    private void enemyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                              
            selectedSpecUnit = enemyComboBox.getSelectedIndex();
            if(selectedSpecUnit == 0){ //DeathKnight
                unitLabel = "<html>Mounted units, which have higher speed, \nand a better armor. Armor reduction \nfor these units would be useful</html>"; 
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 1){ //Demon
                unitLabel = "<html>Demons are one of the fastest units \nin the game. A strong slow debuff is required.</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 2){ //dragon
                unitLabel = "<html>Magical creatures that doesn't prefer breathing fire. To counter them, high damage output and bleed effect would do great.</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 3){ // DwarvenDemolishers
                unitLabel = "<html>These demolishers are a bit slow, yet \nit's hard to take them down due to their \nvast health points. Bleeding them would do well.</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 4){ // ElvenArcher
                unitLabel = "<html>Archers have mediocre health and speed \nvalues. Countering them with arrows would \nbe a considerable and an ironic way.</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 5){ //FlyingMachine
               unitLabel = "<html>Flying machines are fast and armored units. \nDebuff towers are strongly required to \ntake them down.</html>";
               unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 6){ //Footman
                unitLabel = "<html>More handsome cousins of grunts. They trade better armor for less speed.</html>";
                unitLabelText.setText(unitLabel);
             }
            if(selectedSpecUnit == 7){ // Goblins
                unitLabel = "<html>Goblins are the most vulnurable units in the game. To counter this deficiency, they move faster</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 8){ // Grunt
                unitLabel = "<html>Distant relatives of footmen. They prefer less armor for better speed.</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 9){ //GryphonRider
                unitLabel = "<html>Flying units, which have better health and better speed than flying machines. .</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 10){ // Knight
                unitLabel = "<html>They are mounted just like death knights, yet they are not powerful as much as them.</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 11){ // Mage
                unitLabel = "<html>Mages travel with a magical barrier(because it's fancier than saying better armor) that covers them up. .</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 12){ // Ogre
                unitLabel = "<html>Despite being slower, these units have a lot of health points .</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 13){ // Peasant
                unitLabel = "<html>These poor guys are vulnurable to anything. Peasent = easy money.</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 14){ // Peon
                unitLabel = "<html>Orc refugees, which are as miserable as peasents.</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 15){ // Skeleton
                unitLabel = "<html>Skeletons are better than peasants or peons, yet they are not as good as footmen or grunts.</html>";
                unitLabelText.setText(unitLabel);
            }
            if(selectedSpecUnit == 16){ // Troll
                unitLabel = "<html>Trolls have no armor at all. They are slightly slower than the grunts, yet not as weak as the skeletons.</html>";
                unitLabelText.setText(unitLabel);
            }
    }                                             

    private void towerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                              
        selectedSpecUnit = towerComboBox.getSelectedIndex();
        if(selectedSpecUnit == 0){ //Arcane
            unitLabel = "<html>Main purpose this tower is debuffing the armor values of the targets. It has less attack units, high range, and medium attack frequency just like ice tower.</html>"; 
            unitLabelText.setText(unitLabel);
        }
        if(selectedSpecUnit == 1){ //Arrow
            unitLabel = "<html>The most basic and cheapest of all towers. Targeting is single, attack frequency is medium, and attack points are considerably low. Can be used to takeout basic units such as cavalry, and footman.</html>";
            unitLabelText.setText(unitLabel);
        }
        if(selectedSpecUnit == 2){ // Balista
            unitLabel = "<html>Balista has the strongest attack point value that tower can behold in the game. Range is also considerably high, yet it cost of attack frequency. Can be useful against boss units.</html>";
            unitLabelText.setText(unitLabel);
        }
        if(selectedSpecUnit == 3){ // Cannon
            unitLabel = "<html>Can throw projectiles which cause medium attack point and splash damage. Range is high, and frequency is low. Can be used for controlling large hordes.</html>";
            unitLabelText.setText(unitLabel);
        }
        if(selectedSpecUnit == 4){ //Ice
           unitLabel = "<html>This tower can be used to cause speed debuff against the targets. It has medium attack range and frequency, yet it lacks sufficient attack points.</html>";
           unitLabelText.setText(unitLabel);
        }
        if(selectedSpecUnit == 5){ // Mortar
            unitLabel = "<html>It aims on single target. Has medium mediocre attack points, and has high range. It has low attack frequency. Most preferable as an economic choice against big tanky units</html>";
            unitLabelText.setText(unitLabel);
        }
        if(selectedSpecUnit == 6){ // Oil
            unitLabel = "<html>Causes high area damage with tremendous attack points. Should be advantageous enough against slow units. Yet range is the lowest of all, and so the attack frequency.</html>";
            unitLabelText.setText(unitLabel);
        }
        if(selectedSpecUnit == 7){ //Poison
            unitLabel = "<html>Causes bleed damage on targets. Has mediocre attack points, medium range, and high attack frequency.</html>";
            unitLabelText.setText(unitLabel);
        }

    }                                             


    // Variables declaration - do not modify                     
    private javax.swing.JButton backBut;
    private javax.swing.JComboBox<String> enemyComboBox;
    private javax.swing.JComboBox<String> towerComboBox;
    private javax.swing.JLabel unitLabelText;
    private javax.swing.JComboBox<String> unitTypeComboBox;
    // End of variables declaration                   
}
