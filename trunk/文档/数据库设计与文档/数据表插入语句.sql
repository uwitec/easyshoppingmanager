--users
insert into users values('admin','admin', 1,'���ǹ���Ա');
insert into users values('guest','guest', false, '����Ա��');

--supplier
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('�ټѹ�Ӧ��0','��0��','15088888888','0755-3333333','�ټ�0��','0�Ǽ���Ӧ��');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('�ټѹ�Ӧ��1','��1��','15088888888','0755-3333333','�ټ�1��','1�Ǽ���Ӧ��');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('�ټѹ�Ӧ��2','��2��','15088888888','0755-3333333','�ټ�2��','2�Ǽ���Ӧ��');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('�ټѹ�Ӧ��3','��3��','15088888888','0755-3333333','�ټ�3��','3�Ǽ���Ӧ��');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('�ټѹ�Ӧ��4','��4��','15088888888','0755-3333333','�ټ�4��','4�Ǽ���Ӧ��');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('�ټѹ�Ӧ��5','��5��','15088888888','0755-3333333','�ټ�5��','5�Ǽ���Ӧ��');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('�ټѹ�Ӧ��6','��6��','15088888888','0755-3333333','�ټ�6��','6�Ǽ���Ӧ��');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('�ټѹ�Ӧ��7','��7��','15088888888','0755-3333333','�ټ�7��','7�Ǽ���Ӧ��');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('�ټѹ�Ӧ��8','��8��','15088888888','0755-3333333','�ټ�8��','8�Ǽ���Ӧ��');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('�ټѹ�Ӧ��9','��9��','15088888888','0755-3333333','�ټ�9��','9�Ǽ���Ӧ��');

--customer
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('С0����','��0��','15088888888','0755-3333333','������0��','0�Ǽ��ͻ�');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('С1����','��1��','15088888888','0755-3333333','������1��','1�Ǽ��ͻ�');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('С2����','��2��','15088888888','0755-3333333','������2��','2�Ǽ��ͻ�');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('С3����','��3��','15088888888','0755-3333333','������3��','3�Ǽ��ͻ�');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('С4����','��4��','15088888888','0755-3333333','������4��','4�Ǽ��ͻ�');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('С5����','��5��','15088888888','0755-3333333','������5��','5�Ǽ��ͻ�');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('С6����','��6��','15088888888','0755-3333333','������6��','6�Ǽ��ͻ�');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('С7����','��7��','15088888888','0755-3333333','������7��','7�Ǽ��ͻ�');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('С8����','��8��','15088888888','0755-3333333','������8��','8�Ǽ��ͻ�');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('С9����','��9��','15088888888','0755-3333333','������9��','9�Ǽ��ͻ�');

--commoditycategory
insert into commoditycategory(categoryName, categoryRemark) values('����','��ɫ����');
insert into commoditycategory(categoryName, categoryRemark) values('��','��ɫ����');
insert into commoditycategory(categoryName, categoryRemark) values('��','��ɫ�Ľ�');
insert into commoditycategory(categoryName, categoryRemark) values('��','��ɫ����');
insert into commoditycategory(categoryName, categoryRemark) values('��','��ɫ�Ĵ�');

--storeCommodity
insert into storeCommodity(commodityName,specification, unit, price, quantity, minQuantity, commodityRemark, categoryName) values('ɽ������','1��50kg','һ��',100.0, 50, 10, '�ܺõ�ɽ������', '����');









--purchaseRecord
insert into purchaseRecord(commodityName,specification, unit, price, quantity, accountPaid, accountNotPaid, purchaseDate, purchaseRemark, supplierId, userName) values
('ɽ������','1��50kg','һ��','100','1','100','0','2010-02-07 00:00:00','����','11','admin');

insert into purchaseRecord(commodityName,specification, unit, price, quantity, accountPaid, accountNotPaid, purchaseDate, purchaseRemark, supplierId, userName) values
('ɽ������','1��50kg','һ��','100','1','100','0','2010-02-07 00:00:00','��1��','11','admin');

insert into purchaseRecord(commodityName,specification, unit, price, quantity, accountPaid, accountNotPaid, purchaseDate, purchaseRemark, supplierId, userName) values
('ɽ������','1��50kg','һ��','100','1','100','0','2010-02-07 00:00:00','��2��','11','admin');

insert into purchaseRecord(commodityName,specification, unit, price, quantity, accountPaid, accountNotPaid, purchaseDate, purchaseRemark, supplierId, userName) values
('ɽ������','1��50kg','һ��','100','1','100','0','2010-02-07 00:00:00','��3��','11','admin');

insert into purchaseRecord(commodityName,specification, unit, price, quantity, accountPaid, accountNotPaid, purchaseDate, purchaseRemark, supplierId, userName) values
('ɽ������','1��50kg','һ��','100','1','100','0','2010-02-07 00:00:00','��4��','11','admin');

insert into purchaseRecord(commodityName,specification, unit, price, quantity, accountPaid, accountNotPaid, purchaseDate, purchaseRemark, supplierId, userName) values
('ɽ������','1��50kg','һ��','100','1','100','0','2010-02-07 00:00:00','��5��','11','admin');

insert into purchaseRecord(commodityName,specification, unit, price, quantity, accountPaid, accountNotPaid, purchaseDate, purchaseRemark, supplierId, userName) values
('ɽ������','1��50kg','һ��','100','1','100','0','2010-02-07 00:00:00','��6��','11','admin');

insert into purchaseRecord(commodityName,specification, unit, price, quantity, accountPaid, accountNotPaid, purchaseDate, purchaseRemark, supplierId, userName) values
('ɽ������','1��50kg','һ��','100','1','100','0','2010-02-07 00:00:00','��7��','11','admin');

insert into purchaseRecord(commodityName,specification, unit, price, quantity, accountPaid, accountNotPaid, purchaseDate, purchaseRemark, supplierId, userName) values
('ɽ������','1��50kg','һ��','100','1','100','0','2010-02-07 00:00:00','��8��','11','admin');

insert into purchaseRecord(commodityName,specification, unit, price, quantity, accountPaid, accountNotPaid, purchaseDate, purchaseRemark, supplierId, userName) values
('ɽ������','1��50kg','һ��','100','1','100','0','2010-02-07 00:00:00','��9��','11','admin');


insert into purchaseRecord(commodityName,specification, unit, price, quantity, accountPaid, accountNotPaid, purchaseDate, purchaseRemark, supplierId, userName) values
('ɽ������','1��50kg','һ��','100','2','100','0','2010-02-07 00:00:00','��9��','11','admin');






