SELECT h.flavor
    FROM
        july AS j LEFT JOIN first_half AS h
        ON j.flavor = h.flavor
    GROUP BY
        j.flavor
    ORDER BY
        SUM(j.total_order) + AVG(h.total_order) DESC
    LIMIT 3