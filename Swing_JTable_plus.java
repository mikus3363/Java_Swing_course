package kursJava;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Swing_JTable_plus extends JFrame {
    public static void main(String[] args) {
        Swing_JTable_plus frame = new Swing_JTable_plus();

        String[] columns = {"Manufactures","Name","Year","Top speed"};

        String[][] data ={
                {"Ford","T","1920","40"},
                {"Opel","Astra","1970","200"}
        };

        DefaultTableModel model = new DefaultTableModel(data,columns);

        JTable jt = new JTable(model);

        jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane spane = new JScrollPane(jt);

        spane.setPreferredSize(new Dimension(300,100));

        frame.add(spane,BorderLayout.CENTER);
        frame.pack();

        model.insertRow(1,new Object[]{"Dodge","Charger","1990","200"});
        model.insertRow(model.getRowCount(),new Object[]{"Dodge","Charger","2000","200"});

        jt.setCellSelectionEnabled(true);
        jt.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        ListSelectionModel listSelectionModel = jt.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()) return;

                ArrayList<String> arr = new ArrayList<>();

                int selectedRows[] = jt.getSelectedRows();
                int selectedColumns[] = jt.getSelectedColumns();

                for(int i=0;i< selectedRows.length;i++){
                    for(int j=0;j<selectedColumns.length;j++){
                        String selectedData = (String) jt.getValueAt(selectedRows[i],selectedColumns[j]);
                        arr.add(selectedData);
                    }
                }
                System.out.println("Selected: "+arr);
            }
        });

        jt.setShowHorizontalLines(true);
        jt.setGridColor(Color.BLUE);


        jt.setValueAt("35",0,3);//zmiana wartosci
        System.out.println(jt.getValueAt(1,1));
        System.out.println("liczba kolumn: "+jt.getColumnCount());
        System.out.println("nazwa kolumny 0: "+jt.getColumnName(0));

        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
