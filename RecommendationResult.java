package final_project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class RecommendationResult {

    public void showResult(String farmer, String season, String soil,
                           double land, double budget, String[] crops) {

        CropAdvisor advisor = new CropAdvisor();

        JFrame f = new JFrame("Farmer Crop Advisory Report");
        f.setSize(750, 600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Header
        JLabel title = new JLabel("FARMER CROP ADVISORY REPORT", JLabel.CENTER);
        title.setBounds(200, 10, 350, 25);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        f.add(title);

        // Farmer details
        JPanel farmerPanel = new JPanel(new GridLayout(5,1));
        farmerPanel.setBounds(20, 50, 300, 130);
        farmerPanel.setBorder(new TitledBorder("Farmer Details"));
        farmerPanel.add(new JLabel("Farmer Name : " + farmer));
        farmerPanel.add(new JLabel("Season      : " + season));
        farmerPanel.add(new JLabel("Soil Type   : " + soil));
        farmerPanel.add(new JLabel("Land Area   : " + land + " Acres"));
        farmerPanel.add(new JLabel("Budget      : Rs." + budget));
        f.add(farmerPanel);

        // Seasonal alert
        JPanel alertPanel = new JPanel(new GridLayout(3,1));
        alertPanel.setBounds(350, 50, 360, 130);
        alertPanel.setBorder(new TitledBorder("Seasonal Alert"));
        alertPanel.add(new JLabel("Possible Disease :"));
        alertPanel.add(new JLabel(advisor.getDisease(season)));
        alertPanel.add(new JLabel("Natural Treatment : "
                + advisor.getNaturalFertilizer()));
        f.add(alertPanel);

        // Watering method (COMMON)
        String wateringMethod = advisor.getWateringMethod(soil, season);

        // Crop option 1
        JPanel crop1 = new JPanel(new GridLayout(7,1));
        crop1.setBounds(20, 200, 330, 200);
        crop1.setBorder(new TitledBorder("Crop Option 1"));
        crop1.add(new JLabel("Crop Name : " + crops[0]));
        crop1.add(new JLabel("Watering Method : " + wateringMethod));
        crop1.add(new JLabel("Watering Frequency : "
                + advisor.getWateringDays(crops[0])));
        crop1.add(new JLabel("Natural Fertilizer : "
                + advisor.getNaturalFertilizer()));
        crop1.add(new JLabel("Fertilizer Cost : Rs."
                + advisor.getFertilizerCost(crops[0])));
        crop1.add(new JLabel("Estimated Profit : Rs."
                + advisor.getProfit(crops[0])));
        f.add(crop1);

        // Crop option 2
        JPanel crop2 = new JPanel(new GridLayout(7,1));
        crop2.setBounds(380, 200, 330, 200);
        crop2.setBorder(new TitledBorder("Crop Option 2"));
        crop2.add(new JLabel("Crop Name : " + crops[1]));
        crop2.add(new JLabel("Watering Method : " + wateringMethod));
        crop2.add(new JLabel("Watering Frequency : "
                + advisor.getWateringDays(crops[1])));
        crop2.add(new JLabel("Natural Fertilizer : "
                + advisor.getNaturalFertilizer()));
        crop2.add(new JLabel("Fertilizer Cost : Rs."
                + advisor.getFertilizerCost(crops[1])));
        crop2.add(new JLabel("Estimated Profit : Rs."
                + advisor.getProfit(crops[1])));
        f.add(crop2);

        // Final suggestion
        String best = advisor.getProfit(crops[0]) > advisor.getProfit(crops[1])
                ? crops[0] : crops[1];

        JPanel finalPanel = new JPanel();
        finalPanel.setBounds(20, 420, 690, 60);
        finalPanel.setBorder(new TitledBorder("Final Suggestion"));
        finalPanel.add(new JLabel(
                best + " is recommended as it gives higher profit."));
        f.add(finalPanel);

        // Footer
        JLabel footer = new JLabel("🌱 Happy Farming 🌱", JLabel.CENTER);
        footer.setBounds(250, 500, 250, 30);
        footer.setFont(new Font("Arial", Font.BOLD, 14));
        footer.setForeground(new Color(0,128,0));
        f.add(footer);
    }
}
