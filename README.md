# Ecommerce API REST

## ClientController

### Obtener todos los clientes

- **Ruta:** `GET /client/all`
- **Descripción:** Obtiene la lista de todos los clientes registrados.
- **Respuesta Exitosa (200 OK):** Retorna una lista de objetos `Client` que representan a todos los clientes.
- **Respuesta Error (404 Not Found):** Retorna un mensaje indicando que no se encontraron clientes.

### Obtener cliente por ID

- **Ruta:** `GET /client/{id}`
- **Descripción:** Obtiene un cliente por su ID.
- **Parámetros:** 
  - `id`: ID del cliente que se desea obtener.
- **Respuesta Exitosa (200 OK):** Retorna un objeto `ClientDTO` correspondiente al cliente encontrado.
- **Respuesta Error (404 Not Found):** Retorna un mensaje indicando que el cliente no fue encontrado.

### Agregar nuevo cliente

- **Ruta:** `POST /client/add`
- **Descripción:** Crea un nuevo cliente con la información proporcionada.
- **Parámetros del cuerpo:** Objeto `ClientDTO` con los datos del nuevo cliente.
- **Respuesta Exitosa (200 OK):** Retorna el objeto `ClientDTO` creado.
- **Respuesta Error (500 Internal Server Error):** Retorna un mensaje indicando que no se pudo agregar el cliente.

### Actualizar datos de cliente

- **Ruta:** `PUT /client/update`
- **Descripción:** Actualiza los datos de un cliente existente.
- **Parámetros del cuerpo:** Objeto `ClientDTO` con los datos actualizados del cliente.
- **Respuesta Exitosa (200 OK):** Retorna el objeto `ClientDTO` actualizado.
- **Respuesta Error (500 Internal Server Error):** Retorna un mensaje indicando que no se pudieron actualizar los datos del cliente.

---

## ProductController

### Obtener todos los productos

- **Ruta:** `GET /product/all`
- **Descripción:** Obtiene la lista de todos los productos registrados.
- **Respuesta Exitosa (200 OK):** Retorna una lista de objetos `Product` que representan a todos los productos.
- **Respuesta Error (404 Not Found):** Retorna un mensaje indicando que no se encontraron productos.

### Obtener producto por ID

- **Ruta:** `GET /product/{id}`
- **Descripción:** Obtiene un producto por su ID.
- **Parámetros:** 
  - `id`: ID del producto que se desea obtener.
- **Respuesta Exitosa (200 OK):** Retorna un objeto `ProductDTO` correspondiente al producto encontrado.
- **Respuesta Error (404 Not Found):** Retorna un mensaje indicando que el producto no fue encontrado.

### Agregar nuevo producto

- **Ruta:** `POST /product/add`
- **Descripción:** Crea un nuevo producto con la información proporcionada.
- **Parámetros del cuerpo:** Objeto `Product` con los datos del nuevo producto.
- **Respuesta Exitosa (200 OK):** Retorna el objeto `Product` creado.
- **Respuesta Error (500 Internal Server Error):** Retorna un mensaje indicando que no se pudo agregar el producto.

### Actualizar datos de producto

- **Ruta:** `PUT /product/update`
- **Descripción:** Actualiza los datos de un producto existente.
- **Parámetros del cuerpo:** Objeto `ProductDTO` con los datos actualizados del producto.
- **Respuesta Exitosa (200 OK):** Retorna el objeto `ProductDTO` actualizado.
- **Respuesta Error (500 Internal Server Error):** Retorna un mensaje indicando que no se pudieron actualizar los datos del producto.

---
## SaleController

### Obtener todas las ventas

- **Ruta:** `GET /sale/all`
- **Descripción:** Obtiene la lista de todas las ventas registradas.
- **Método:** `GET`
- **Respuesta Exitosa (200 OK):**
  - Tipo: `ResponseEntity<List<Sale>>`
  - Descripción: Retorna la lista de objetos `Sale`.
- **Respuesta Error (404 Not Found):**
  - Tipo: `ResponseStatusException`
  - Descripción: Retorna un mensaje indicando que no se encontraron detalles de ventas.

### Agregar nueva venta

- **Ruta:** `POST /sale/add`
- **Descripción:** Agrega una nueva venta con los productos proporcionados.
- **Método:** `POST`
- **Parámetros del cuerpo:**
  - Tipo: `ClientsProductsToBuy`
  - Descripción: Objeto que contiene la información de la venta.
- **Respuesta Exitosa (200 OK):**
  - Tipo: `ResponseEntity<PurchaseResponseDTO>`
  - Descripción: Retorna el objeto `PurchaseResponseDTO` correspondiente a la nueva venta.
- **Respuesta Error (404 Not Found):**
  - Tipo: `ResponseStatusException`
  - Descripción: Retorna un mensaje indicando un error en la carga.

---
## SaleController

### Obtener todos los detalles de ventas

- **Ruta:** `GET /sales-details/all`
- **Descripción:** Obtiene la lista de todos los detalles de ventas registrados.
- **Método:** `GET`
- **Respuesta Exitosa (200 OK):**
  - Tipo: `ResponseEntity<List<SaleDetails>>`
  - Descripción: Retorna la lista de objetos `SaleDetails`.
- **Respuesta Error (404 Not Found):**
  - Tipo: `ResponseStatusException`
  - Descripción: Retorna un mensaje indicando que no se encontraron detalles de ventas.

---
 
 
