package com.demo.fxgldemo.configurations;


import com.almasb.fxgl.core.EngineService;
import com.almasb.fxgl.core.collection.PropertyMap;
import javafx.beans.property.IntegerProperty;

/*
    ** Esta clase CurrencyService lo que hace es:
     * La clase extiende EngineService, que es parte del sistema de servicios proporcionado por FXGL. Los servicios en FXGL son componentes reutilizables que pueden ser inyectados y utilizados en otras partes del juego.
Propiedad de Moneda (currency):
* Utiliza un PropertyMap llamado map para almacenar la propiedad "currency". Un PropertyMap es una estructura de datos proporcionada por FXGL que permite almacenar propiedades dinámicamente.
Inicialización del Valor de Moneda:
* En el constructor de la clase, se establece el valor inicial de "currency" en 0 utilizando el método setValue() del PropertyMap.
Métodos Get y Set para la Moneda:
* getCurrency(): Devuelve el valor actual de la moneda almacenada en la propiedad.
* setCurrency(int value): Establece el valor de la moneda en el valor proporcionado.
Propiedad IntegerProperty para Moneda:
* currencyProperty(): Devuelve un IntegerProperty asociado con la propiedad "currency". Un IntegerProperty es una propiedad observable que permite a los objetos registrarse para recibir notificaciones cuando cambia su valor.

* * En resumen:
* Proporciona un "servicio" para gestionar la moneda en el juego.
* Se utiliza para mantener un rastreo del valor de la moneda.
* Proporciona métodos para acceder y actualizar ese valor, así como una propiedad observable para permitir que otras partes del juego se notifiquen cuando cambia la moneda.

 */
public class CurrencyService extends EngineService {

    private PropertyMap map = new PropertyMap();

    public CurrencyService() {
        map.setValue("currency", 0);
    }

    public int getCurrency() {
        return map.getInt("currency");
    }

    public void setCurrency(int value) {
        map.setValue("currency", value);
    }

    public IntegerProperty currencyProperty() {
        return map.intProperty("currency");
    }
}
