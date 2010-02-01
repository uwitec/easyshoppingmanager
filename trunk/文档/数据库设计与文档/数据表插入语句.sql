--users
insert into users values('admin','admin', 1,'我是管理员');
insert into users values('guest','guest', false, '我是员工');

--supplier
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('百佳供应商0','李0四','15088888888','0755-3333333','百佳0号','0星级供应商');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('百佳供应商1','李1四','15088888888','0755-3333333','百佳1号','1星级供应商');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('百佳供应商2','李2四','15088888888','0755-3333333','百佳2号','2星级供应商');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('百佳供应商3','李3四','15088888888','0755-3333333','百佳3号','3星级供应商');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('百佳供应商4','李4四','15088888888','0755-3333333','百佳4号','4星级供应商');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('百佳供应商5','李5四','15088888888','0755-3333333','百佳5号','5星级供应商');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('百佳供应商6','李6四','15088888888','0755-3333333','百佳6号','6星级供应商');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('百佳供应商7','李7四','15088888888','0755-3333333','百佳7号','7星级供应商');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('百佳供应商8','李8四','15088888888','0755-3333333','百佳8号','8星级供应商');
insert into supplier(name, contactName, contactPhone1, contactPhone2, address, remark) values('百佳供应商9','李9四','15088888888','0755-3333333','百佳9号','9星级供应商');

--customer
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('小0肥羊','张0三','15088888888','0755-3333333','肥羊大街0号','0星级客户');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('小1肥羊','张1三','15088888888','0755-3333333','肥羊大街1号','1星级客户');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('小2肥羊','张2三','15088888888','0755-3333333','肥羊大街2号','2星级客户');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('小3肥羊','张3三','15088888888','0755-3333333','肥羊大街3号','3星级客户');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('小4肥羊','张4三','15088888888','0755-3333333','肥羊大街4号','4星级客户');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('小5肥羊','张5三','15088888888','0755-3333333','肥羊大街5号','5星级客户');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('小6肥羊','张6三','15088888888','0755-3333333','肥羊大街6号','6星级客户');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('小7肥羊','张7三','15088888888','0755-3333333','肥羊大街7号','7星级客户');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('小8肥羊','张8三','15088888888','0755-3333333','肥羊大街8号','8星级客户');
insert into customer(customerName, contactName, contactPhone1, contactPhone2, customerAddress, customerRemark) values('小9肥羊','张9三','15088888888','0755-3333333','肥羊大街9号','9星级客户');

--commoditycategory
insert into commoditycategory(categoryName, categoryRemark) values('大米','白色的米');
insert into commoditycategory(categoryName, categoryRemark) values('油','黄色的油');
insert into commoditycategory(categoryName, categoryRemark) values('酱','黑色的酱');
insert into commoditycategory(categoryName, categoryRemark) values('盐','白色的盐');
insert into commoditycategory(categoryName, categoryRemark) values('醋','红色的醋');

--storeCommodity
insert into storeCommodity(commodityName,specification, unit, price, quantity, minQuantity, commodityRemark, categoryName) values('山东大米','1×50kg','一袋',100.0, 50, 10, '很好的山东大米', '大米');