package main;

class RoiDesBonbons {

    private static RoiDesBonbons single_instance = null;

    public static RoiDesBonbons getInstance()
    {
        if (single_instance == null)
            single_instance = new RoiDesBonbons();

        return single_instance;
    }

    public Bonbon SouhaitBonbon(String nomBonbon){
        return null;
    }
}
