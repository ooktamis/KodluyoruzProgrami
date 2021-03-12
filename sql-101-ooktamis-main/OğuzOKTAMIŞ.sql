--********************************SORU:1********************************
select customer.first_name AS isim ,customer.last_name as soy_isim from customer inner join payment on
customer.customer_id=payment.customer_id where payment.payment_date>='2007-04-01'
--********************************SORU:2********************************
select film.release_year as cikis_yili, film.title as adi,category.name as kategorisi from film inner join film_category on
film.film_id=film_category.film_id inner join category on 
category.category_id=film_category.category_id where category.name='Action' or category.name='Animation'
--********************************SORU:3********************************
select payment.payment_date as odeme_tarihi, customer.first_name as musteri_adi, customer.last_name as musteri_soyadi from customer inner join 
payment on payment.customer_id=customer.customer_id where  payment_date in (select max(payment_date) from payment) 
--********************************SORU:4********************************
select film.film_id as film_Id,film.title as film_adi from film 
where film.film_id not in (select inventory.film_id from film inner join inventory on inventory.film_id=film.film_id )
and  title between 'P' and 'Z'
--********************************SORU:5********************************
select customer.first_name as musteri_adi , customer.last_name as musteri_soyadi, sum(payment.amount) as toplam_odeme from customer inner join 
payment on payment.customer_id=customer.customer_id where customer.first_name like 'B%'
group by  customer.first_name , customer.last_name










