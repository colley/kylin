select count(*) as c,sum(gmv) as g,cast(sum(item_count) as BIGINT) AS i from streaming_table group by minute_start