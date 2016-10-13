package shop;

import java.util.List;

public interface Cart {
    void add();
    List<Long> getPids();
}