CREATE TABLE `order_table` (
                         `order_id` VARCHAR(255) PRIMARY KEY,
                         `portfolio_id` VARCHAR(255),
                         `account_id` VARCHAR(255),
                         `order_state` INT,
                         `creator` VARCHAR(255),
                         `modifier` VARCHAR(255),
                         `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

CREATE TABLE `order_detail` (
                                `id` INT PRIMARY KEY AUTO_INCREMENT,
                                `order_id` VARCHAR(255) NOT NULL,
                                `sec_id` VARCHAR(255),
                                `company_name` VARCHAR(255),
                                `direction` TINYINT,
                                `quantity` INT,
                                `price` DECIMAL(10,2),
                                `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `account` (
                           `account_id` VARCHAR(255) PRIMARY KEY,
                           `total_capital` DECIMAL(10,2),
                           `available_capital` DECIMAL(10,2),
                           `frozen_capital` DECIMAL(10,2),
                           `settle_capital` DECIMAL(10,2),
                           `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `inventory` (
                             `id` INT PRIMARY KEY AUTO_INCREMENT,
                             `portfolio_id` VARCHAR(255),
                             `sec_id` VARCHAR(255),
                             `holding_quantity` INT,
                             `frozen_holding_quantity` INT,
                             `cost_price` DECIMAL(10,2),
                             `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

