//Mehmet Emir ERDEM - 20360859091

package biyolojiodevi2;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;

public class Biyolojiodevi2 extends JFrame {
    JTable jtb1;
    JScrollPane js;
    
    Biyolojiodevi2(){
        super("Dot Matrix");
        
        Scanner input = new Scanner(System.in);
        System.out.println("k değerini giriniz (1, 2 veya 3 olabilir):");
        int k = input.nextInt();
        System.out.println("target sekansının baz sayısını giriniz:");
        int n = input.nextInt()+1;
        String[] seq1 = new String[n];
        System.out.println("target sekansının bazlarını teker teker giriniz:");
        for(int i=1;i<seq1.length;i++){
            seq1[i] = input.next();
        }
        seq1[0]=" ";
        
        System.out.println("query sekansının baz sayısını giriniz:");
        int m = input.nextInt();
        String[] seq2 = new String[m];
        System.out.println("query sekansının bazlarını teker teker giriniz:");
        for(int i=0;i<seq2.length;i++){
            seq2[i] = input.next();
        }
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        DefaultTableModel model = new DefaultTableModel(seq1, seq2.length);
        jtb1 = new JTable(model);
        jtb1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        for(int i=0;i<seq2.length;i++){
            model.setValueAt(seq2[i], i, 0);
        }
        
        js=new JScrollPane(jtb1);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        js.setBounds(0, 20, 560, 280);
        js.setVisible(true);
        this.add(js);
        
        doldur(model,seq1,seq2,k);
        this.setSize(600,420);
        this.setVisible(true);
        
        
        
    }
    
    void doldur(DefaultTableModel model,String[] seq1,String[] seq2,int k){
        
        switch (k) {
            case 1:
                for(int i=1;i<seq1.length;i++){
                    for(int j=0;j<seq2.length;j++){
                        if(Arrays.asList(seq1[i]).contains(seq2[j])){
                            model.setValueAt("*", j, i);
                            if(model.getValueAt(j,i).equals("*")){
                                TableColumn sutun = jtb1.getColumnModel().getColumn(i);
                                sutun.setCellRenderer(new Boyayici());

                            }
                        }
                    }
                }   
                break;
            case 2:
                for(int i=1;i<seq1.length;i++){
                    for(int j=0;j<seq2.length;j++){
                        if(Arrays.asList(seq1[i]).contains(seq2[j]) && Arrays.asList(seq1[i+1]).contains(seq2[j+1]) ){
                            model.setValueAt("*", j, i);
                            if(model.getValueAt(j,i).equals("*")){
                                TableColumn sutun = jtb1.getColumnModel().getColumn(i);
                                sutun.setCellRenderer(new Boyayici());
                                
                            }
                        }
                    }
                }   
                break;
            case 3:
                for(int i=1;i<seq1.length;i++){
                    for(int j=0;j<seq2.length;j++){
                        if(Arrays.asList(seq1[i]).contains(seq2[j]) && Arrays.asList(seq1[i+1]).contains(seq2[j+1]) && Arrays.asList(seq1[i+2]).contains(seq2[j+2]) ){
                            model.setValueAt("*", j, i);
                            if(model.getValueAt(j,i).equals("*")){
                                TableColumn sutun = jtb1.getColumnModel().getColumn(i);
                                sutun.setCellRenderer(new Boyayici());
                                
                            }
                        }
                    }
                }    
                break;
            default:
                System.out.println("Bulunmayan k değeri girdiniz.");
                break;
        }
    }

    class Boyayici extends DefaultTableCellRenderer {
        
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
            
            Random random = new Random();
            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);

            Color randomcolor = new Color(r,g,b);
            
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setBackground(randomcolor);
            return cell;
        }
    }
    
    public static void main(String[] args) {
        Biyolojiodevi2 d = new Biyolojiodevi2();
    }
    
}
