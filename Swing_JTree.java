package kursJava;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

public class Swing_JTree extends JFrame {
    public static void main(String[] args) {
        Swing_JTree frame = new Swing_JTree();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        JTree tree = new JTree(root);

        DefaultMutableTreeNode cars = new DefaultMutableTreeNode("cars");
        cars.add(new DefaultMutableTreeNode("Dodge"));
        cars.add(new DefaultMutableTreeNode("Astra"));
        cars.add(new DefaultMutableTreeNode("Punto"));
        root.add(cars);

        DefaultMutableTreeNode bikes = new DefaultMutableTreeNode("bikes");
        bikes.add(new DefaultMutableTreeNode("Honda"));
        bikes.add(new DefaultMutableTreeNode("BMW"));
        root.add(bikes);

        for(int i = 0;i<tree.getRowCount();i++) tree.expandRow(i);

        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object el = e.getNewLeadSelectionPath().getLastPathComponent();
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) el;
                System.out.println("selected: "+node.toString());
            }
        });

        frame.add(tree);


        frame.setSize(400,400);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
