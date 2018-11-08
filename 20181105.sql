alter table qlbh.vattuchungtuchitiet 
modify column ThanhTien decimal(18,2), 
modify column SoLuong decimal(18,2), 
add column DonGia decimal(18,2);
alter table qlbh.vattu drop column Barcode;