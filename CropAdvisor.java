package final_project;

public class CropAdvisor {

    // Crop combinations
    public String[] getCrops(String season, String soil) {

        if (season.equals("Rainy") && soil.equals("Loamy"))
            return new String[]{"Groundnut", "Maize"};

        if (season.equals("Rainy") && soil.equals("Clay"))
            return new String[]{"Paddy", "Pulses"};

        if (season.equals("Summer"))
            return new String[]{"Millet", "Cotton"};

        return new String[]{"Pulses", "Vegetables"};
    }

    // Disease based on season
    public String getDisease(String season) {
        if (season.equals("Rainy")) return "Fungal disease / Leaf spot";
        if (season.equals("Summer")) return "Pest attack";
        return "Minor fungal infection";
    }

    // Natural fertilizer
    public String getNaturalFertilizer() {
        return "Vermicompost / Cow dung manure";
    }

    // NEW: Watering method based on soil & season
    public String getWateringMethod(String soil, String season) {

        if (soil.equals("Sandy"))
            return "Sprinkler Irrigation";

        if (soil.equals("Clay") && season.equals("Rainy"))
            return "Canal Irrigation";

        if (soil.equals("Loamy"))
            return "Drip Irrigation";

        return "Manual / Pipe Irrigation";
    }

    // Watering frequency
    public String getWateringDays(String crop) {
        if (crop.equals("Groundnut")) return "Once every 7 days";
        if (crop.equals("Maize")) return "Once every 6 days";
        if (crop.equals("Paddy")) return "Once every 3 days";
        if (crop.equals("Millet")) return "Once every 8 days";
        return "Once every 10 days";
    }

    // Fertilizer cost
    public int getFertilizerCost(String crop) {
        if (crop.equals("Groundnut")) return 2500;
        if (crop.equals("Maize")) return 1800;
        if (crop.equals("Paddy")) return 3000;
        if (crop.equals("Millet")) return 1500;
        return 1200;
    }

    // Cultivation cost
    public int getCost(String crop) {
        if (crop.equals("Groundnut")) return 8000;
        if (crop.equals("Maize")) return 6000;
        if (crop.equals("Paddy")) return 12000;
        if (crop.equals("Cotton")) return 15000;
        if (crop.equals("Millet")) return 4000;
        return 3000;
    }

    // Market price
    public int getMarketPrice(String crop) {
        if (crop.equals("Groundnut")) return 6500;
        if (crop.equals("Maize")) return 2000;
        if (crop.equals("Paddy")) return 2200;
        if (crop.equals("Cotton")) return 7000;
        if (crop.equals("Millet")) return 3000;
        return 2500;
    }

    // Profit calculation
    public int getProfit(String crop) {
        int yield = 10; // quintals per acre
        return (getMarketPrice(crop) * yield) - getCost(crop);
    }
}
