# SpringProject
TABLO-DTO iliskisinde anladiklarim
hocanin yaptigi projede DTO class larina obje eklememis. 
mesela student class inin icinde book objesi var ama studentDTO da yok.
yani client'tan yeni student kaydi icin aldigimiz requestin icinde book objesi olmayacak ama 
biz book ekledigimizde zaten tablolar arasinda baglanti kurdugumuz icin onlari kendi iliskilendirecek.
yani student ve book ayri ayri DB e kaydedilecek sonra kendi tablolarda bizim onceden olusturdugumuz kolonlara onlari id olarak ekleyecek
