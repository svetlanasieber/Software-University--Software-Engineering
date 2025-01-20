package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer {
    private static final double GLACIER_EXPLORER_INITIAL_ENERGY = 40.0;


    public GlacierExplorer(String name) {
        super(name, GLACIER_EXPLORER_INITIAL_ENERGY);
    }


}
