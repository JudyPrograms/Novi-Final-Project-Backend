-- INITIAL GAME DATA
INSERT INTO avatars (name, sub_name, img_location)
VALUES
('Warrior', 'Anonymous', ''),
('Kusunoki', 'The Adventurous', ''),
('Myamoto', 'The Inspirator', ''),
('Takeda', 'The Persistent', ''),
('Toyotomi', 'The Embracing', '');

INSERT INTO levels (number, name)
VALUES
(1, 'Hurricane'),
(2, 'Tornado'),
(3, 'Thunderstorm'),
(4, 'Whirlwind'),
(5, 'Breeze');


-- TEST USER DATA
INSERT INTO users (username, email, password, admin)
VALUES
('UserOne', 'user1@gmail.com', '!Qwer1234', TRUE),
('Newby', 'newby@gmail.com', '!Qwer1234', FALSE),
('Experienced', 'exp@gmail.com', '!Qwer1234', FALSE);

--INSERT INTO players (user_id, subtask_count, total_points, avatar_id, level_id)
INSERT INTO players (user_id, subtask_count, total_points, level_id)
VALUES (3, 2.3, 76, 2);

