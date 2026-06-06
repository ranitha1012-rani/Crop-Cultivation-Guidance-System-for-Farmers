package final_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CropAdvisoryForm implements ActionListener {

    JFrame f;
    JLabel lSeason, lSoil, lLand, lBudget, lWater;
    JComboBox<String> cbSeason, cbSoil, cbWater;
    JTextField tLand, tBudget;
    JButton b;

    public CropAdvisoryForm() {

        f = new JFrame("Crop Advisory");
        f.setSize(700, 450);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // -------- SEASON --------
        lSeason = new JLabel("Season");
        lSeason.setBounds(50, 60, 120, 25);
        f.add(lSeason);

        cbSeason = new JComboBox<>(new String[]{"Rainy", "Summer", "Winter"});
        cbSeason.setBounds(200, 60, 150, 25);
        f.add(cbSeason);

        // -------- SOIL TYPE --------
        lSoil = new JLabel("Soil Type");
        lSoil.setBounds(50, 110, 120, 25);
        f.add(lSoil);

        cbSoil = new JComboBox<>(new String[]{"Loamy", "Clay", "Sandy"});
        cbSoil.setBounds(200, 110, 150, 25);
        f.add(cbSoil);

        // -------- LAND --------
        lLand = new JLabel("Land (Acres)");
        lLand.setBounds(50, 160, 120, 25);
        f.add(lLand);

        tLand = new JTextField();
        tLand.setBounds(200, 160, 150, 25);
        f.add(tLand);

        // -------- BUDGET --------
        lBudget = new JLabel("Budget (Rs)");
        lBudget.setBounds(50, 210, 120, 25);
        f.add(lBudget);

        tBudget = new JTextField();
        tBudget.setBounds(200, 210, 150, 25);
        f.add(tBudget);

        // -------- WATERING TYPE (NEW) --------
        lWater = new JLabel("Watering Type");
        lWater.setBounds(50, 260, 120, 25);
        f.add(lWater);

        cbWater = new JComboBox<>(new String[]{
                "Canal Irrigation",
                "Sprinkler Irrigation",
                "Drip Irrigation",
                "Pipe / Manual Watering"
        });
        cbWater.setBounds(200, 260, 180, 25);
        f.add(cbWater);

        // -------- BUTTON --------
        b = new JButton("Get Recommendation");
        b.setBounds(200, 320, 180, 35);
        f.add(b);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String season = cbSeason.getSelectedItem().toString();
        String soil = cbSoil.getSelectedItem().toString();
        String waterType = cbWater.getSelectedItem().toString();

        double land = Double.parseDouble(tLand.getText());
        double budget = Double.parseDouble(tBudget.getText());

        CropAdvisor advisor = new CropAdvisor();
        String[] crops = advisor.getCrops(season, soil);

        RecommendationResult result = new RecommendationResult();
        result.showResult(
                "Farmer",
                season,
                soil,
                land,
                budget,
                crops
        );

        JOptionPane.showMessageDialog(f,
                "Selected Watering Type : " + waterType);
    }

    public static void main(String[] args) {
        new CropAdvisoryForm();
    }
}