package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, Collection<Explorer> explorers) {


        Collection<String> exhibits = state.getExhibits();

        explorers.forEach(explorer -> {
            while (explorer.canSearch() && exhibits.iterator().hasNext()) {
                String currentState = exhibits.iterator().next();
                explorer.search();
                explorer.getSuitcase().getExhibits().add(currentState);
                exhibits.remove(currentState);
            }
        });
    }
}





