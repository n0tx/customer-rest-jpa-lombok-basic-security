-- app_user
INSERT INTO public.app_user (id, full_name, "password", username) VALUES(1, 'Administrator', '$2a$10$Q/DowegpvrcJVAQFtLPEHuGRSk4mjC5XlwqH63vJ6CcZlNTyIsz32', 'admin');
INSERT INTO public.app_user (id, full_name, "password", username) VALUES(2, 'Riki Candra', '$2a$10$Q/DowegpvrcJVAQFtLPEHuGRSk4mjC5XlwqH63vJ6CcZlNTyIsz32', 'riki');

-- role
INSERT INTO public."role" (id, "name") VALUES(1, 'ADMIN');
INSERT INTO public."role" (id, "name") VALUES(2, 'READER');

-- user_role
INSERT INTO public.user_role (user_id, role_id) VALUES(1, 1);
INSERT INTO public.user_role (user_id, role_id) VALUES(2, 2);

-- customer_address
INSERT INTO public.customer_address (id, address, customer, province) VALUES(1, 'address jakarta', 'andi', 'DKI Jakarta');
INSERT INTO public.customer_address (id, address, customer, province) VALUES(2, 'address jambi', 'budi', 'Jambi');
