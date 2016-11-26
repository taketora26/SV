ALTER TABLE company ADD `image_url` VARCHAR(4096) DEFAULT NULL AFTER company_product_id ;

UPDATE company SET  `image_url` = "http://store.hbo.com/imgcache/product/resized/000/800/957/catl/silicon-valley-pied-piper-mouse-pad-858_1000.jpg?k=d0ab6436&pid=800957&s=catl&sn=hbo" WHERE id = 1 ;
UPDATE company SET  `image_url` = "http://store.hbo.com/imgcache/product/resized/000/558/189/catl/silicon-valley-hooli-t-shirt-" WHERE id = 2 ;