/**
 * 
 */
package com.yin.springbootbeetlsql.convert;

/**
 * @author Bean
 *
 */
public interface IConvertPostHandler<PO, VO> {
	public void post(PO po, VO vo);
}
