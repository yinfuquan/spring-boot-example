getUserById
===
*订单首页信息
SELECT
		user.*,
		user.name as nm
FROM
	uc_users  user
WHERE
      1=1
    @if(isNotEmpty(userId)){
    	AND user.id=#userId#
    @}




selectPage
===
*订单首页信息
SELECT

	@pageTag() {
			user.*,
        	user.name as nm
	@}


FROM
	uc_users  user

