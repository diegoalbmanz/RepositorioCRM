/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;



import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Paint;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import model.EmpleadoModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import pojos.Empleado;



/**
 *
 * @author herre
 */
public class Principal extends javax.swing.JDialog {
    
   private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());

    private Empleado empleado;
    /**
     * Creates new form Bienvenida
     */
    public Principal(Empleado empleado) {
        this.empleado = empleado;
        initComponents();

        FlatLightLaf.setup();   
        UIManager.put("Panel.background", Color.WHITE); // fondo blanco
        UIManager.put("Button.arc", 30); // redondeo solo para botones
              

        getContentPane().setBackground(new Color(230, 230, 230));

        //Título
        setTitle("CRM Music Shop - Página Principal");

        //Tamaño, redimensionamiento y centrado
        setSize(1250, 800);  
        setResizable(false);  
        setLocationRelativeTo(null);

        UIManager.put("Button.arc", 30); // redondeo solo para botones

        //Icono de la ventana
        Image icon = new ImageIcon(getClass().getResource("/img/iconoApp.png")).getImage();
        setIconImage(icon);
        
        //Cargamos el gráfico con las ventas de los empleados
        cargarGraficoVentas();
        
        //Cargamos el gráfico de las categorías de los productos
        cargarGraficoProductos();        
    }
 
    
    //Método para construis el gráfico con las ventas de los empleados
      private void cargarGraficoVentas() {

        //Crear Dataset del gráfico
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        //Obtenemos los empleados
        EmpleadoModel model = new EmpleadoModel();
        ArrayList<Empleado> lista = (ArrayList<Empleado>) model.getTodos();

        //Añadimos una barra por empleado
        for (Empleado emp : lista) {
            dataset.addValue(
                    emp.getMontoVentas(),   // valor de la barra
                    "Ventas",               // serie (solo una)
                    "ID " + emp.getId()     // etiqueta en el eje X
            );
        }

        //Creamos el gráfico de barras
        JFreeChart chart = ChartFactory.createBarChart(
                "Ventas por Empleado",     // título
                "Empleado",                // eje X
                "Ventas (€)",              // eje Y
                dataset,
                PlotOrientation.VERTICAL,
                false,                      // leyenda
                true,                       // tooltips
                false
        );

        //Configuramos el plot
        CategoryPlot plot = chart.getCategoryPlot();

        //Renderer personalizado:
        //Se encarga de decidir el color de cada barra justo cuando se pinta
        BarRenderer renderer = new BarRenderer() {

            @Override
            public Paint getItemPaint(int row, int column) {

                //column = posición del empleado en la lista
                double ventas = lista.get(column).getMontoVentas();

                //Color según el volumen de ventas
                if (ventas < 1000) {
                    return Color.RED;           //ventas bajas
                } else if (ventas >= 1000 && ventas < 2000) {
                    return Color.YELLOW;        //ventas medias
                } else {
                    return Color.GREEN;         //ventas altas
                }
            }
        };

        //Asignamos el renderer al plot
        plot.setRenderer(renderer);

        //Quitar borde negro de las barras (más limpio)
        renderer.setDrawBarOutline(false);

        //Insertamos el gráfico en el panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true); // zoom con la rueda

        pnGraficoVentas.removeAll();
        pnGraficoVentas.setLayout(new BorderLayout());
        pnGraficoVentas.add(chartPanel, BorderLayout.CENTER);
        pnGraficoVentas.revalidate();
        pnGraficoVentas.repaint();
    }

      //Método para crear el gráfico de pastel con las categorías de los productos
      private void cargarGraficoProductos() {

        // Dataset del pastel
        org.jfree.data.general.DefaultPieDataset<String> dataset = new org.jfree.data.general.DefaultPieDataset<>();

        // Obtener productos
        model.ProductoModel pm = model.ProductoModel.getInstance();
        java.util.List<pojos.Producto> lista = pm.getTodos();

        // Contadores por categoría
        int cuerda = 0;
        int percusion = 0;
        int teclado = 0;
        int viento = 0;

        for (pojos.Producto p : lista) {
            switch (p.getCategoria()) {
                case "Cuerda" -> cuerda++;
                case "Percusión" -> percusion++;
                case "Teclado" -> teclado++;
                case "Viento" -> viento++;
            }
        }

        // Añadir datos al dataset
        dataset.setValue("Cuerda", cuerda);
        dataset.setValue("Percusión", percusion);
        dataset.setValue("Teclado", teclado);
        dataset.setValue("Viento", viento);

        // Crear gráfico de pastel
        JFreeChart chart = ChartFactory.createPieChart(
                "Productos por Categoría",
                dataset,
                true,   // leyenda
                true,   // tooltips
                false
        );

        // Panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);

        // Insertar en pnGraficoProductos
        pnGraficoProductos.removeAll();
        pnGraficoProductos.setLayout(new BorderLayout());
        pnGraficoProductos.add(chartPanel, BorderLayout.CENTER);
        pnGraficoProductos.revalidate();
        pnGraficoProductos.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblOfertas = new javax.swing.JLabel();
        lblObjetivos = new javax.swing.JLabel();
        pnGraficoVentas = new javax.swing.JPanel();
        pnGraficoProductos = new javax.swing.JPanel();
        pnCabecera = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 750));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BIENVENIDO A MUSICALSHOP CRM");
        jLabel2.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Página de Inicio");

        lblOfertas.setBackground(new java.awt.Color(255, 255, 255));
        lblOfertas.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblOfertas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOfertas.setText("Ofertas");
        lblOfertas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        lblOfertas.setOpaque(true);
        lblOfertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOfertasMouseClicked(evt);
            }
        });

        lblObjetivos.setBackground(new java.awt.Color(255, 255, 255));
        lblObjetivos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblObjetivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblObjetivos.setText("Objetivos de ventas");
        lblObjetivos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 153, 255)));
        lblObjetivos.setOpaque(true);
        lblObjetivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblObjetivosMouseClicked(evt);
            }
        });

        pnGraficoVentas.setLayout(new java.awt.BorderLayout());

        pnGraficoProductos.setLayout(new java.awt.BorderLayout());

        pnCabecera.setBackground(new java.awt.Color(204, 204, 204));
        pnCabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setText("Inicio");
        pnCabecera.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 20));

        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        pnCabecera.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 100, 20));

        btnPedidos.setText("Pedidos");
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });
        pnCabecera.add(btnPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 100, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(lblObjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblOfertas, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnGraficoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnGraficoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 1238, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblOfertas, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(lblObjetivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnGraficoProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addComponent(pnGraficoVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        GaleriaProductos galeria = new GaleriaProductos(empleado);
        galeria.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnProductosActionPerformed

    //Abrimos el PDF Objetivos
    private void lblObjetivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblObjetivosMouseClicked
        abrirPDF("/pdf/objetivos.pdf");
    }//GEN-LAST:event_lblObjetivosMouseClicked

    //Abrimos el PDF Ofertas
    private void lblOfertasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOfertasMouseClicked
        abrirPDF("/pdf/ofertas.pdf");
    }//GEN-LAST:event_lblOfertasMouseClicked

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPedidosActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnProductos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblObjetivos;
    private javax.swing.JLabel lblOfertas;
    private javax.swing.JPanel pnCabecera;
    private javax.swing.JPanel pnGraficoProductos;
    private javax.swing.JPanel pnGraficoVentas;
    // End of variables declaration//GEN-END:variables

    //Método para poder abrir un PDF desde NetBeans
    private void abrirPDF(String ruta) {
        try{
            InputStream is = getClass().getResourceAsStream(ruta);      //Cargamos el PDF como recurso
            if(is == null){
                System.err.println("No se encontró el PDF");
                return;
            }
            
            //Creamos un pdf temporal
            File temp = File.createTempFile("MusicalShop", ".pdf");
            temp.deleteOnExit();    //Lo eliminamos al cerrar
            
            //leemos el archivo temporal, copia dle original
            try(FileOutputStream fos = new FileOutputStream(temp)){
                byte[] buffer = new byte[1024];     //Buffer de copia
                int bytesRead;
                
                //Leemos el pdf
                while ((bytesRead = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);    //Escritura temporal
                }
            }
            
            //Abrimos el PDF con el visor predeterminado
            Desktop.getDesktop().open(temp);
            
        }catch (Exception ex) { 
            ex.printStackTrace();
        } 
    }
}

