pageOrderList
===
*订单首页信息	
SELECT
	@pageTag() {
		od.* ,
		ge.name as event_name,
		user.mobile as user_mobile,
		saledp.name as sale_department_name,
		leader.name as leader_name
	@}
FROM
	gp_group_orders od ,
	gp_group_events ge ,
	gp_users user ,
	gp_users leader,
	gp_departments saledp
WHERE
        od.group_event_id = ge.id 
    AND od.buy_user_id = user.id    
    AND od.sale_department_id = saledp.id    
    AND od.leader_user_id = leader.id
    AND od.status=1    AND ge.status=1   AND user.status=1  AND leader.status=1 
    AND saledp.status=1 
    @if(isNotEmpty(groupEventId)){
    	AND ge.id=#groupEventId#
    @}
	@if(isNotEmpty(orderNo)){
		AND od.order_no=#orderNo#
	@}
	@if(isNotEmpty(eventName)){
		AND ge.name=#eventName#
	@}
	
