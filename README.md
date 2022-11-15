# RecyclerViewDemo
[![](https://jitpack.io/v/burningtomato/RecyclerViewDemo.svg)](https://jitpack.io/#burningtomato/RecyclerViewDemo)

一个很简单的Adapter，配合DataBinding使用。

目的

  现在开发的时候，很喜欢使用DataBinding
  这样在项目中可以节省很多敲变量的时间哈~


## 如何使用

### Step 1.先在 build.gradle(Project:XXXX) 的 repositories 添加:
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
	
### Step 2.然后在 build.gradle(Module:app) 的 dependencies 添加:
```gradle
dependencies {
	        implementation 'com.github.burningtomato:RecyclerViewDemo:Tag'
	}
```
  
  ### 具体使用
  #### 新建BTAdapter
  ```gradle
    private void testAdapter() {
        adapter = new BTAdapter<MainBean, ItemLayoutBinding>(R.layout.item_layout) {
            @Override
            public void convert(@NonNull BTViewHolder<ItemLayoutBinding> holder, MainBean data) {
                holder.binding.txContent.setText(data.getContent() + data.getIndex());
            }
        };

        activityMainBinding.recyclerView.setAdapter(adapter);
    }
        
  ```
  #### 加载数据
```gradle    
private void initDataList(){
        for (int i = 0; i < 30; i++) {
            adapter.addData(new MainBean("这个是测试数据", i));
        }
    }
 ```
 #### 直接调用
 
 这个只是为了提示：一定要先创建Adapter
```gradle
    testAdapter();
    initDataList();
```
