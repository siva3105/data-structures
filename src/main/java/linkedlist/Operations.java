package linkedlist;

public interface Operations {
    void insert(int value);

    void insertAtStart(int value);

    void insertAt(int value, int position);

    void deleteAt(int index);

    int get(int Index);

    void show();
}
