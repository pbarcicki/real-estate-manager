package projects.realestatemanager.loader;

public interface DataLoader extends Comparable<DataLoader>{

    void loadData();

    int getOrder();

    default int compareTo(DataLoader o){
        return this.getOrder() - o.getOrder();
    }
}
