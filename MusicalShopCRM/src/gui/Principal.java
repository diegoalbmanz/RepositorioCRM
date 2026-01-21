/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;



import com.formdev.flatlaf.FlatClientProperties;
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

        jLabel4.setText("Bienvenido , \n"+ empleado.getNombre());
        
        jLabel4.setOpaque(true); // IMPORTANTE: Obligatorio para ver el color de fondo

        lblOfertas.putClientProperty(FlatClientProperties.STYLE, 
    "arc: 20;" +                // Redondeo de esquinas
    "background: #ffffff;" +    // Color de fondo específico
    "border: 1,1,1,1, #cccccc, 1, 20" // Un borde sutil (opcional)
);
                lblObjetivos.putClientProperty(FlatClientProperties.STYLE, 
    "arc: 20;" +                // Redondeo de esquinas
    "background: #ffffff;" +    // Color de fondo específico
    "border: 1,1,1,1, #cccccc, 1, 20" // Un borde sutil (opcional)
);
                pnPDFS.putClientProperty(FlatClientProperties.STYLE, 
    "arc: 20;" +                // Redondeo de esquinas
    "background: #99CCFF;" +    // Color de fondo específico
    "border: 1,1,1,1, #cccccc, 1, 20" // Un borde sutil (opcional)
);
jLabel4.putClientProperty(FlatClientProperties.STYLE, 
    "arc: 20;"                 // El redondeo
);

pnGraficoVentas.putClientProperty(FlatClientProperties.STYLE, 
    "arc: 20;" +                // Redondeo de esquinas
    "background: #ffffff;" +    // Color de fondo específico
    "border: 1,1,1,1, #cccccc, 1, 20" // Un borde sutil (opcional)
);
        pnGraficoProductos.putClientProperty(FlatClientProperties.STYLE, 
    "arc: 20;" +                // Redondeo de esquinas
    "background: #ffffff;" +    // Color de fondo específico
    "border: 1,1,1,1, #cccccc, 1, 20" // Un borde sutil (opcional)
);

        
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

        pnGraficoVentas = new javax.swing.JPanel();
        pnGraficoProductos = new javax.swing.JPanel();
        pnCabecera = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnPDFS = new javax.swing.JPanel();
        lblObjetivos = new javax.swing.JLabel();
        lblOfertas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 750));

        pnGraficoVentas.setLayout(new java.awt.BorderLayout());

        pnGraficoProductos.setLayout(new java.awt.BorderLayout());

        pnCabecera.setBackground(new java.awt.Color(255, 255, 255));
        pnCabecera.setForeground(new java.awt.Color(50, 112, 236));
        pnCabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        pnCabecera.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 60, 20));

        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        pnCabecera.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 110, 20));

        btnPedidos.setText("Pedidos");
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });
        pnCabecera.add(btnPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 100, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoApp 2.png"))); // NOI18N
        pnCabecera.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 40));
        pnCabecera.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel4.setBackground(new java.awt.Color(153, 204, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setOpaque(true);

        pnPDFS.setBackground(new java.awt.Color(153, 204, 255));

        lblObjetivos.setBackground(new java.awt.Color(255, 255, 255));
        lblObjetivos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblObjetivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblObjetivos.setText("Objetivos de ventas");
        lblObjetivos.setOpaque(true);
        lblObjetivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblObjetivosMouseClicked(evt);
            }
        });

        lblOfertas.setBackground(new java.awt.Color(255, 255, 255));
        lblOfertas.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        lblOfertas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOfertas.setText("Ofertas");
        lblOfertas.setOpaque(true);
        lblOfertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOfertasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnPDFSLayout = new javax.swing.GroupLayout(pnPDFS);
        pnPDFS.setLayout(pnPDFSLayout);
        pnPDFSLayout.setHorizontalGroup(
            pnPDFSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPDFSLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblOfertas, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblObjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        pnPDFSLayout.setVerticalGroup(
            pnPDFSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPDFSLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnPDFSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOfertas, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnGraficoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnGraficoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnPDFS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(pnPDFS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnGraficoProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(pnGraficoVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Abrimos el PDF Objetivos
    private void lblObjetivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblObjetivosMouseClicked
        abrirPDF("/pdf/objetivos.pdf");
    }//GEN-LAST:event_lblObjetivosMouseClicked

    //Abrimos el PDF Ofertas
    private void lblOfertasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOfertasMouseClicked
        abrirPDF("/pdf/ofertas.pdf");
    }//GEN-LAST:event_lblOfertasMouseClicked

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        Principal bienvenida = new Principal(empleado);
        bienvenida.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        GaleriaProductos galeria = new GaleriaProductos(empleado);
        galeria.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        // TODO add your handling code here:
              Pedidos p = new Pedidos(null , true,empleado);
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPedidosActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnProductos;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblObjetivos;
    private javax.swing.JLabel lblOfertas;
    private javax.swing.JPanel pnCabecera;
    private javax.swing.JPanel pnGraficoProductos;
    private javax.swing.JPanel pnGraficoVentas;
    private javax.swing.JPanel pnPDFS;
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

