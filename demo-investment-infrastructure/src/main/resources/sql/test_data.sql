INSERT INTO `account` (`account_id`, `total_capital`, `available_capital`, `frozen_capital`, `settle_capital`)
VALUES ('0086699525', 100000.00, 80000.00, 20000.00, 5000.00);

INSERT INTO `inventory` (`portfolio_id`, `sec_id`, `holding_quantity`, `frozen_holding_quantity`, `cost_price`)
VALUES
('XYJG000047', 'ABC123', 100, 0, 25.99),
('XYJG000047', 'XYZ789', 150, 0, 39.99),
('XYJG000047', 'DEF456', 80, 0, 19.99),
('XYJG000047', 'GHI789', 200, 0, 49.99),
('XYJG000047', 'JKL012', 120, 0, 29.99),
('XYJG000047', 'MNO345', 180, 0, 34.99);
