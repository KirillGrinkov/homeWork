package FamilyTree.FamilyTree.Model.Tree;

import FamilyTree.FamilyTree.Model.Person.Comporators.PersonComparatorByChildren;
import FamilyTree.FamilyTree.Model.Person.Comporators.PersonComparatorByAge;
import FamilyTree.FamilyTree.Model.Person.Person;

import java.io.Serializable;
import java.util.*;

public class FamilyTree <E extends TreeItem<E>> implements Serializable, Iterable<E> {
    private HashMap<Integer, E> personList;
    private int personId = 0;
    public FamilyTree() {
        this.personList = new HashMap<Integer, E>();
    }

    public void addPerson(E person){
        this.personList.put(personId++,person);
    }

    public void setParent(E person, E parent){
        person.addParent((Person) parent);
    }

    public E getPersonById(int id){
        return(personList.get(id));
    }

    public boolean checkId(int id){
        return personList.containsKey(id);
    }
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("Family tree:\n");
        for (Map.Entry<Integer, E> item : personList.entrySet()){
            tmp.append("id = " +item.getKey()+"\n");
            tmp.append(item.getValue().toString());
            tmp.append("\n");
        }

        return tmp.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<E>((List<E>) personList);
    }
    public ArrayList<String> sortByAge(){
        ArrayList<String> result = new ArrayList<String>();

        personList.entrySet().stream()
                .sorted(new PersonComparatorByAge<E>())
                .forEach(e -> result.add("id = " + e.getKey().toString() +"\n" + e.getValue().toString()));
        return result;
    }

    public ArrayList<String> sortByChildren(){
        ArrayList<String> result = new ArrayList<String>();
        personList.entrySet().stream()
                .sorted(new PersonComparatorByChildren<E>())
                .forEach(e -> result.add("id = " + e.getKey().toString() +"\n" + e.getValue().toString()));
        return result;
    }

    public E getById(int id) {
            return(personList.get(id));
        }

    public boolean checkId(long id) {
        return id < personId && id >= 0;
    }

}










