/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import pojos.Producto;

public class ProductoModel {
    private static ProductoModel instance;
    private List<Producto> productos;

    private ProductoModel() {
        productos = new ArrayList<>();

        productos.add(new Producto(1, "Yamaha C2X PE", "Teclado",
                "Piano de cola de la serie CX con sonido brillante, gran proyección y acabado Polished Ebony.",
                23990.0, 1, "/img/12.png"));

        productos.add(new Producto(2, "Harley Benton Fusion III HSS Roasted FNT", "Cuerda",
                "Guitarra eléctrica con cuerpo de tilo, mástil roasted maple y configuración HSS.",
                349.0, 10, "/img/1.png"));

        productos.add(new Producto(3, "Buffet Crampon E11", "Viento",
                "Clarinete en Si♭ fabricado en granadilla, ideal para estudiantes avanzados y nivel medio.",
                899.0, 5, "/img/18.png"));

        productos.add(new Producto(4, "Mapex Comet Pro Pack 22 Dark Black", "Percusión",
                "Set de batería acústica completo con bombo de 22'', herrajes incluidos y acabado Dark Black.",
                499.0, 6, "/img/10.png"));

        productos.add(new Producto(5, "Startone Student I Violin Set 4/4", "Cuerda",
                "Violín 4/4 económico para principiantes, incluye arco y estuche rígido.",
                129.0, 12, "/img/28.png"));

        productos.add(new Producto(6, "Korg Pa5X‑61 Oriental", "Teclado",
                "Workstation profesional con 61 teclas, sonidos orientales dedicados, motor EDS‑XP y secuenciador avanzado.",
                4699.0, 3, "/img/16.png"));

        productos.add(new Producto(7, "Yamaha YAS‑280S", "Viento",
                "Saxofón alto para estudiantes con acabado plateado, mecanismo estable y gran facilidad de emisión.",
                1099.0, 4, "/img/20.png"));

        productos.add(new Producto(8, "Córdoba GK Studio Limited", "Cuerda",
                "Guitarra flamenca de cuerpo delgado, tapa de abeto europeo y aros/lados de ziricote.",
                699.0, 6, "/img/6.png"));

        productos.add(new Producto(9, "Sonor AQX Studio Set RMS", "Percusión",
                "Batería compacta ideal para estudio y directo, con cascos de álamo y hardware Sonor.",
                699.0, 4, "/img/11.png"));

        productos.add(new Producto(10, "Yamaha YCL‑255S Bb", "Viento",
                "Clarinete en Si♭ para estudiantes, cuerpo de resina ABS y llaves plateadas.",
                499.0, 8, "/img/19.png"));

        productos.add(new Producto(11, "Fender American Pro II Strat HSS Dark Night", "Cuerda",
                "Stratocaster profesional con pastillas HSS, acabado Dark Night y mástil Deep C.",
                1899.0, 5, "/img/2.png"));

        productos.add(new Producto(12, "Gewa Allegro VC1 Cello Set 4/4", "Cuerda",
                "Violonchelo 4/4 con tapa de abeto macizo, fondo de arce y estuche incluido.",
                899.0, 3, "/img/25.png"));

        productos.add(new Producto(13, "Yamaha PSR‑SX920", "Teclado",
                "Workstation arranger con 61 teclas, motor de sonido AWM, pantalla táctil y funciones avanzadas de acompañamiento.",
                1999.0, 5, "/img/15.png"));

        productos.add(new Producto(14, "Thomann SL39", "Viento",
                "Trombón tenor con vara suave, campana de latón y excelente relación calidad‑precio.",
                199.0, 10, "/img/22.png"));

        productos.add(new Producto(15, "Karl Höfner Allegretto 4/4 Violin Outfit", "Cuerda",
                "Violín 4/4 de gama media con tapa de abeto seleccionada y fondo de arce flameado.",
                699.0, 4, "/img/29.png"));

        productos.add(new Producto(16, "DW DWe E33 Drum Kit Midnight Blue", "Percusión",
                "Batería electrónica profesional con cascos de madera, sistema DWe y acabado Midnight Blue.",
                3499.0, 2, "/img/9.png"));

        productos.add(new Producto(17, "Kawai GL-10 E/P Grand Piano", "Teclado",
                "Piano de cola compacto con acción Millennium III y excelente respuesta tonal.",
                8990.0, 2, "/img/13.png"));

        productos.add(new Producto(18, "Yamaha V5 SA44 Violin Set 4/4", "Cuerda",
                "Violín 4/4 para estudiantes, tapa de abeto macizo y fondo/arcos de arce.",
                499.0, 6, "/img/27.png"));

        productos.add(new Producto(19, "Fender American Ultra II Tele MN Arctic Velvet", "Cuerda",
                "Telecaster de gama alta con perfil Modern D, pastillas Ultra Noiseless y acabado Arctic Velvet.",
                2399.0, 3, "/img/5.png"));

        productos.add(new Producto(20, "Ketron Event 61", "Teclado",
                "Arranger de alta gama con estilos realistas, motor híbrido de audio y 61 teclas semicontrapesadas.",
                3890.0, 2, "/img/17.png"));

        productos.add(new Producto(21, "Gewa Allegro VC1 Cello Set 4/4", "Cuerda",
                "Violonchelo 4/4 con tapa de abeto macizo, fondo de arce y estuche incluido.",
                899.0, 3, "/img/26.png"));

        productos.add(new Producto(22, "Yamaha YSL‑891Z Jazz Trombone", "Viento",
                "Trombón profesional para jazz con diseño Z, gran proyección y excelente respuesta.",
                2499.0, 2, "/img/23.png"));

        productos.add(new Producto(23, "Hanika Flamenco KF", "Cuerda",
                "Guitarra flamenca artesanal con tapa de abeto y cuerpo de ciprés, fabricación alemana.",
                2490.0, 2, "/img/8.png"));

        productos.add(new Producto(24, "Steinway & Sons B-211", "Teclado",
                "Piano de cola profesional considerado el estándar en estudios y salas de concierto.",
                129000.0, 1, "/img/14.png"));

        productos.add(new Producto(25, "BetterSax Session Alto Matte Gold", "Viento",
                "Saxofón alto con acabado mate dorado, afinación estable y diseño orientado a estudiantes avanzados.",
                1299.0, 3, "/img/21.png"));

        productos.add(new Producto(26, "Cort KX500 PM Natural", "Cuerda",
                "Guitarra moderna con tapa Poplar Burl, pastillas Fishman Fluence y construcción premium.",
                799.0, 8, "/img/3.png"));

        productos.add(new Producto(27, "Alhambra 4F Flamenco", "Cuerda",
                "Guitarra flamenca con tapa de abeto alemán, cuerpo de sicomoro y golpeador transparente.",
                799.0, 5, "/img/7.png"));

        productos.add(new Producto(28, "Yamaha YTR‑4335GII", "Viento",
                "Trompeta en Si♭ con campana de latón dorado, ideal para estudiantes avanzados.",
                799.0, 6, "/img/24.png"));

        productos.add(new Producto(29, "Fender American Pro II Tele MN Roasted Pine", "Cuerda",
                "Telecaster profesional con cuerpo de pino tostado, mástil Deep C y electrónica mejorada.",
                1799.0, 4, "/img/4.png"));
    }



    public static ProductoModel getInstance() {
        if (instance == null) instance = new ProductoModel();
        return instance;
    }
    
    public Producto getPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean hayStock(int id, int cantidad) {
        Producto p = getPorId(id);
        return p != null && p.getStock() >= cantidad;
    }

    public boolean actualizarStock(int id, int cantidad) {
        Producto p = getPorId(id);
        if (p != null && p.getStock() >= cantidad) {
            p.setStock(p.getStock() - cantidad);
            return true;
        }
        return false;
    }

    public List<Producto> getTodos() { return productos; }
}