< ? x m l   v e r s i o n = " 1 . 0 "   e n c o d i n g = " U T F - 1 6 " ? > 
 < x s l : s t y l e s h e e t   v e r s i o n = " 1 . 0 "   x m l n s : x s l = " h t t p : / / w w w . w 3 . o r g / 1 9 9 9 / X S L / T r a n s f o r m " > 
 	 < x s l : o u t p u t   m e t h o d = " t e x t " / > 
 	 < x s l : t e m p l a t e   m a t c h = " / " > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " r u l e b a s e " / > 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " r u l e b a s e " > 
 	 	 < x s l : i f   t e s t = " @ r d f _ i m p o r t " > ( i m p o r t - r d f   < x s l : v a l u e - o f   s e l e c t = " @ r d f _ i m p o r t " / > ) < / x s l : i f > 
 	 	 < x s l : t e x t > 
 	 	 < / x s l : t e x t > 
 	 	 < x s l : i f   t e s t = " @ r d f _ e x p o r t " > ( e x p o r t - r d f   < x s l : v a l u e - o f   s e l e c t = " @ r d f _ e x p o r t " / > 
 	 	 	 < x s l : t e x t >     < / x s l : t e x t > 
 	 	 	 < x s l : v a l u e - o f   s e l e c t = " @ r d f _ e x p o r t _ c l a s s e s " / > ) < / x s l : i f > 
 	 	 < x s l : t e x t > 
 	 	 < / x s l : t e x t > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " i m p " / > 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " i m p " > 
 ( < x s l : a p p l y - t e m p l a t e s   s e l e c t = " _ r l a b " / > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " _ b o d y " / > 
     = >   
 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " _ h e a d " / > 
 )   
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " _ r l a b " > 
 	 	 < x s l : i f   t e s t = " @ m a i n t a i n a b l e = ' n o ' " > n t m - < / x s l : i f > 
 	 	 < x s l : v a l u e - o f   s e l e c t = " @ r u l e t y p e " / > 
 	 	 < x s l : t e x t >   < / x s l : t e x t > 
 	 	 < x s l : v a l u e - o f   s e l e c t = " i n d " / > 
 	 	 < x s l : t e x t > 
 	 	 < / x s l : t e x t > 
 	 	 < ! - - 
 	 	 < x s l : i f   t e s t = " @ s u p e r i o r " > 
 	 	 	 < x s l : t e x t > ( d e c l a r e   ( s u p e r i o r   < / x s l : t e x t > 
 	 	 	 < x s l : v a l u e - o f   s e l e c t = " @ s u p e r i o r " / > 
 	 	 	 < x s l : t e x t > ) )   
 	 	 	 < / x s l : t e x t > 
 	 	 < / x s l : i f > - - > 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " _ b o d y " > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " a t o m | n a f | a n d " / > 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " a n d " > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " a t o m | n a f " / > 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " _ h e a d " > 
 	 	 < x s l : i f   t e s t = " c a l c " > ( c a l c   < x s l : a p p l y - t e m p l a t e s   s e l e c t = " c a l c " / > ) < / x s l : i f > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " a t o m " / > 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " c a l c " > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " f u n c t i o n _ c a l l " / > 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " n a f " > 
 	 	 ( n o t 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " a t o m " / > 
 	 	 ) 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " a t o m " >   
 	 < x s l : i f   t e s t = " _ i d " > 
 	   < x s l : a p p l y - t e m p l a t e s   s e l e c t = " _ i d / v a r | _ i d / i n d " / >   
 	   < x s l : t e x t >   " & l t ; - "   < / x s l : t e x t > 
 	 < / x s l : i f > 
 	 ( < ! - - < x s l : i f   t e s t = " s t r i n g - l e n g t h ( n o r m a l i z e - s p a c e ( _ o p r / r e l ) ) = 0 " > 
 	 	 	 < x s l : v a l u e - o f   s e l e c t = " _ o p r / r e l / @ h r e f " / > 
 	 	 < / x s l : i f > - - > 
 	 	 < ! - - < x s l : i f   t e s t = " s t r i n g - l e n g t h ( n o r m a l i z e - s p a c e ( _ o p r / r e l ) ) > 0 " > - - > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " _ o p r / r e l " / > 
 	 	 < ! - - < / x s l : i f > - - > 
 	 	 < ! - - < x s l : i f   t e s t = " s t r i n g - l e n g t h ( n o r m a l i z e - s p a c e ( _ o p r / r e l ) ) = 0 " > ? < / x s l : i f > - - > 
 	 	 < x s l : t e x t >   < / x s l : t e x t > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " _ p a t h | _ s l o t | _ v a r s l o t " / > 
 	 ) 
   < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " _ s l o t " > 
 	 	 ( < x s l : v a l u e - o f   s e l e c t = " @ n a m e " / > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " v a r | i n d | _ n o t | _ a n d | o r | a g g r e g a t e _ f u n c t i o n _ c a l l " / > 
 	 	 ) 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " _ p a t h " > 
 	 ( ( < x s l : a p p l y - t e m p l a t e s   s e l e c t = " s l o t n a m e | g e n p a t h | r e c p a t h " / > ) 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " v a r | i n d | _ n o t | _ a n d | o r | a g g r e g a t e _ f u n c t i o n _ c a l l " / > 
 	 ) 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " _ v a r s l o t " > 
 	 	 ( ? < x s l : v a l u e - o f   s e l e c t = " @ n a m e " / > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " v a r | i n d | _ n o t | _ a n d | o r | a g g r e g a t e _ f u n c t i o n _ c a l l " / > 
 	 	 ) 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " s l o t n a m e " > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " v a r | i n d " / > 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " g e n p a t h " > 
 	 	 < x s l : i f   t e s t = " v a r / @ t y p e = m u l t i " > 
 	 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " v a r " / > 
 	 	 < / x s l : i f > 
 	 	 < x s l : i f   t e s t = " v a r / @ t y p e = s i n g l e " > 
 	 	 	 $ < x s l : a p p l y - t e m p l a t e s   s e l e c t = " v a r " / > 
 	 	 < / x s l : i f > 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " r e c p a t h " > 
 	 ( < x s l : a p p l y - t e m p l a t e s   s e l e c t = " s l o t n a m e " / > ) 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " v a r " > 
 	 	 < x s l : i f   t e s t = " @ t y p e = ' s i n g l e ' " > 
 	 	 < x s l : t e x t >   ? < / x s l : t e x t > 
 	 	 < / x s l : i f > 
 	 	 < x s l : i f   t e s t = " @ t y p e = ' m u l t i ' " > 
 	 	 < x s l : t e x t >   $ ? < / x s l : t e x t > 
 	 	 < / x s l : i f > 
 	 	 < x s l : i f   t e s t = " @ t y p e = ' s i n g l e - m u l t i ' " > 
 	 	 < x s l : t e x t >   ? ? < / x s l : t e x t > 
 	 	 < / x s l : i f > 
 	 	 < x s l : v a l u e - o f   s e l e c t = " . " / > 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " i n d " > 
 	 	 < x s l : t e x t >   < / x s l : t e x t > 
 	 	 < x s l : v a l u e - o f   s e l e c t = " . " / > 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " f u n c t i o n _ c a l l " > 
 	 	 ( < x s l : v a l u e - o f   s e l e c t = " @ n a m e " / > 
 	 	 < x s l : t e x t >   < / x s l : t e x t > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " i n d | v a r | f u n c t i o n _ c a l l " / > 
 	 	 ) 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " a g g r e g a t e _ f u n c t i o n _ c a l l " > 
 	 	 ( < x s l : v a l u e - o f   s e l e c t = " @ n a m e " / > 
 	 	 < x s l : t e x t >   < / x s l : t e x t > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " v a r " / > 
 	 	 ) 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " _ n o t " > 
 	 	 < x s l : t e x t >   ~ < / x s l : t e x t > 
 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " v a r | i n d " / > 
 	 < / x s l : t e m p l a t e > 
 	 < x s l : t e m p l a t e   m a t c h = " _ a n d " > 
 	 	 < x s l : t e x t >   < / x s l : t e x t > 
 	 	 < x s l : f o r - e a c h   s e l e c t = " v a r | i n d | _ n o t | f u n c t i o n _ c a l l " > 
 	 	 	 < x s l : c h o o s e > 
 	 	 	 	 < x s l : w h e n   t e s t = " n a m e ( . ) = & q u o t ; v a r & q u o t ; " > 
 	 	 	 	 	 < x s l : t e x t >   ? < / x s l : t e x t > 
 	 	 	 	 	 < x s l : v a l u e - o f   s e l e c t = " . " / > 
 	 	 	 	 < / x s l : w h e n > 
 	 	 	 	 < x s l : w h e n   t e s t = " n a m e ( . ) = & q u o t ; i n d & q u o t ; " > 
 	 	 	 	 	 < x s l : t e x t >   < / x s l : t e x t > 
 	 	 	 	 	 < x s l : v a l u e - o f   s e l e c t = " . " / > 
 	 	 	 	 < / x s l : w h e n > 
 	 	 	 	 < x s l : w h e n   t e s t = " n a m e ( . ) = & q u o t ; f u n c t i o n _ c a l l & q u o t ; " > 
 	 	 	 	 	 < x s l : t e x t >   : < / x s l : t e x t > 
 	 	 	 	 	 < x s l : v a r i a b l e   n a m e = " f u n c _ p o s "   s e l e c t = " p o s i t i o n ( ) " / > 
 	 	 	 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " . . / * [ p o s i t i o n ( ) = $ f u n c _ p o s ] " / > 
 	 	 	 	 < / x s l : w h e n > 
 	 	 	 	 < x s l : w h e n   t e s t = " n a m e ( . ) = & q u o t ; _ n o t & q u o t ; " > 
 	 	 	 	 	 < x s l : t e x t >   ~ < / x s l : t e x t > 
 	 	 	 	 	 < x s l : a p p l y - t e m p l a t e s   s e l e c t = " v a r | i n d " / > 
 	 	 	 	 < / x s l : w h e n > 
 	 	 	 < / x s l : c h o o s e > 
 	 	 	 < x s l : i f   t e s t = " n o t   ( p o s i t i o n ( ) = l a s t ( ) ) " > 
 	 	 	 	 < x s l : t e x t >   & a m p ;   < / x s l : t e x t > 
 	 	 	 < / x s l : i f > 
 	 	 < / x s l : f o r - e a c h > 
 	 < / x s l : t e m p l a t e > 
 < / x s l : s t y l e s h e e t > 
 