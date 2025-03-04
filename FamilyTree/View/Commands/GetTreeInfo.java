package FamilyTree.FamilyTree.View.Commands;

import FamilyTree.FamilyTree.View.ConsoleUI;
public class GetTreeInfo extends Command {

    public GetTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Запросить список членов семьи";
    }

    @Override
    public void execute() {
        consoleUI.getTreeListInfo();
    }
}
