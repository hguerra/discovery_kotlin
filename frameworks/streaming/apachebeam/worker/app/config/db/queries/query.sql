-- name: GetPerson :one
SELECT * FROM person
WHERE id = $1 LIMIT 1;
