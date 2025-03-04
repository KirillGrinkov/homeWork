package FamilyTree.FamilyTree.View.Commands;

import FamilyTree.FamilyTree.View.ConsoleUI;

public class AddPerson extends Command {

    public AddPerson(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить члена семьи";
    }

    @Override
    public void execute() {
        consoleUI.addPerson();
    }
}