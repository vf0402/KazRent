DROP DATABASE IF EXISTS kazRent;
CREATE DATABASE kazRent;

\connect kazRent;


CREATE TABLE t_sizes (
    id SERIAL PRIMARY KEY,
    size_name VARCHAR(255) NOT NULL
);

CREATE TABLE t_categories (
    id SERIAL PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);

CREATE TABLE t_products (
    id SERIAL PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    product_quantity INT NOT NULL,
    category_id INT NOT NULL REFERENCES t_categories(id)
);

CREATE TABLE t_customers (
    id SERIAL PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    customer_phone VARCHAR(20),
    password VARCHAR(255)
);

CREATE TABLE t_orders (
    id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL REFERENCES t_customers(id),
    order_date DATE NOT NULL,
    order_status VARCHAR(255) NOT NULL
);

CREATE TABLE t_order_products (
    id SERIAL PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    size_id INT NOT NULL,
    quantity INT NOT NULL,
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES t_orders(id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES t_products(id),
    CONSTRAINT fk_size FOREIGN KEY (size_id) REFERENCES t_sizes(id)
);



---------------------Данные логистической компании------------------
--INSERT INTO t_warehouses(warehouse_name, warehouse_address) VALUES ('ALMATY LOGISTICS', 'площадь Республики, 2/2, Алматы')
--
--
--INSERT INTO t_news (news_title, news_content, news_date, image_path)
--VALUES ('Расширение складских помещений', 'Наша логистическая компания с радостью объявляет о расширении наших складских помещений. Благодаря увеличенной вместимости мы сможем разместить больше товаров и обеспечить более быструю и эффективную обработку заказов для наших клиентов. Это расширение является подтверждением нашего стремления к удовлетворению растущих потребностей наших клиентов и обеспечению бесперебойной логистики.',
--		NOW(), 'https://orlando1464.hocoos.com/_ipx/f_webp,q_90/https://img2.hocoos.com/cache/img-pack/1324/w-1900/h-720/ww-1900/wh-720/img-pack/1324/pexels-cottonbro-4046148.jpg');
--
--INSERT INTO t_news (news_title, news_content, news_date, image_path)
--VALUES ('Введение экологически чистых транспортных средств для доставки',
--		'В рамках нашей постоянной работы по снижению углеродного следа, мы с гордостью представляем парк экологически чистых транспортных средств для доставки. Эти транспортные средства работают на электричестве или гибридной технологии, что значительно снижает выбросы и способствует устойчивому транспорту. Принятие этих экологически чистых транспортных средств является нашим вкладом в более зеленое будущее и предоставлением экологически осознанных логистических решений нашим клиентам',
--		NOW(), 'https://orlando1464.hocoos.com/_ipx/f_webp,q_90/https://img2.hocoos.com/cache/img-pack/1324/w-1900/h-720/ww-1900/wh-720/img-pack/1324/pexels-laura-tancredi-7078717.jpg');
--
--INSERT INTO t_news (news_title, news_content, news_date, image_path)
--VALUES ('Новое партнерство для международных перевозок',
--		'Мы с радостью объявляем о нашем новом партнерстве с глобальным поставщиком услуг по международным перевозкам, расширяя наши возможности для международных перевозок. Это сотрудничество позволит нам проникнуть на новые рынки, улучшить нашу сеть перевозок и предложить конкурентные тарифы для международных отправлений. С данной партнерской программой мы стремимся предоставить комплексные логистические решения для бизнесов, желающих расширить свою деятельность на международном уровне.',
--		NOW(), 'https://orlando1464.hocoos.com/_ipx/f_webp,q_90/https://img2.hocoos.com/cache/img-pack/1324/w-1900/h-720/ww-1900/wh-720/img-pack/1324/pexels-cottonbro-7437499.jpg');
--





