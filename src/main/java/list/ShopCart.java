package list;
/*
 * 购物车
 * 
 * */

import java.util.ArrayList;
import java.util.List;

public class ShopCart {
	//将购买的商品保存到list
	private List<Product> list = new ArrayList<Product>();
	
	//商品在list中是否存在,如果存在返回该商品，否则返回空
	private Product contains(int pid) {
		for(Product o:list) {
			if(o.getPid() == pid) {
				//存在
				return o;
			}
		}
		return null;
	}
	//从仓库中根据id读取到对应的商品
	protected Product getProduct(int pid) {
		for(Product p:Store.products) {
			if(p.getPid() == pid) {
				return p;
			}
		}
		return null;
	}
	
	/*
	 * 新增商品
	 * 如果list中已经存在该商品，则修改数量，如果不存在则添加
	 * */
	public void addNew(int pid) {
		Product tmp = this.contains(pid);//从购物车中找到对应的商品
		Product p = this.getProduct(pid);//从仓库中找到对应商品
		if(tmp == null) {
			//存在则新增
			Product np = new Product();
			np.setPid(p.getPid());
			np.setCount(1);
			np.setName(p.getName());
			np.setPrive(p.getPrive());
			np.setTotal(np.getPrive() * np.getCount());
			p.setCount(1);
			p.setTotal(p.getPrive() * p.getCount());
			this.list.add(np);
		}else {
			//不存在修改数量
			tmp.setCount(tmp.getCount() + 1);//数量加1
			tmp.setTotal(tmp.getPrive() * tmp.getCount());
		}
	}
	
	/*
	 * 移除商品
	 * */
	public void remove(int pid) {
		for(Product p:this.list) {
			if(p.getPid() == pid) {
				this.list.remove(p);
				break;
			}
		}
	}
	
	
	/*
	 * 清空
	 * */
	public void clear() {
		this.list.clear();
	}
	
	
	/*
	 * 修改数量
	 * */
	public void modify(int pid,int newCount) {
		Product p = this.contains(pid);//根据pid找到商品对象
		p.setCount(newCount);//修改数量
		p.setTotal(p.getPrive() * p.getCount());
	}
	
	
	/*
	 * 获取所有商品
	 * */
	public List<Product> getAll(){
		return this.list;
	}
	
}
