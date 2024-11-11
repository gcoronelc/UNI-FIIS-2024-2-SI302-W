
SELECT 
	c.id_categoria AS IDCATEGORIA, 
	c.nombre AS NOMBRE, 
	SUM(d.cantidad) AS CANTIDAD_TOTAL, 
	SUM(d.subtotal) AS VENTAS_TOTAL 
FROM PRODUCTO p 
JOIN CATEGORIA c ON c.id_categoria = p.id_categoria 
JOIN DETALLE_VENTA d ON d.id_producto = p.id_producto 
GROUP BY c.id_categoria, c.nombre 
ORDER BY c.id_categoria ASC 
GO





