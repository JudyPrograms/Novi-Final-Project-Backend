-- INITIAL GAME DATA
INSERT INTO avatars (name, sub_name, img_location)
VALUES
('Warrior', 'Anonymous', ''),
('Kusunoki', 'The Adventurous', ''),
('Myamoto', 'The Inspirator', ''),
('Takeda', 'The Persistent', ''),
('Toyotomi', 'The Embracing', '');

INSERT INTO levels (level_number, name)
VALUES
(1, 'Hurricane'),
(2, 'Tornado'),
(3, 'Thunderstorm'),
(4, 'Whirlwind'),
(5, 'Breeze');

INSERT INTO slices (slice_number, slice_text)
VALUES
(1, 'get and open all envelopes'),
(2, 'create four piles: action-wait-store-trash'),
(3, 'throw out -trash- pile'),
(4, 'put -store- letters in organizer'),
(5, 'put -wait- letters on top in organizer'),
(6, 'write -action- on all other letters');


---- TEST USER DATA
--INSERT INTO users (username, email, password, is_admin)
--VALUES
--('UserOne', 'user1@gmail.com', '!Qwer1234', TRUE),
--('Newby', 'newby@gmail.com', '!Qwer1234', FALSE),
--('Experienced', 'exp@gmail.com', '!Qwer1234', FALSE);

--INSERT INTO players (user_id, subtask_count, total_points, avatar_id, level_id)
--INSERT INTO players (user_id, subtask_count, total_points, level_number, avatar_name)
--VALUES (3, 2.3, 76, 2, 'Myamoto');

