package exam1;

import java.util.ArrayList;
import java.util.List;


public class Main {

	
	 //position variables:
	  int up=0,down=0,right=0;
	  
	  int start_row_index=0;
	  int start_col_index=0;
	 
	  int flag;
	  
	  //to store next element and its index
	  int nextelement=0;
	  int nextelement_row_index=0;
	  int nextelement_col_index=0;
	
	  //to check whether element is visited or not
	boolean visited[][]=new boolean[4][4];
	
	
	//to Print Matrix
	public void printMatrix(int Mat[][]){
		
		for(int i=0;i<Mat.length;i++){
			
			for(int j=0;j<Mat[i].length;j++){
				
				
				System.out.print(" "+Mat[i][j]);
			}
			System.out.println("");
		}
		
	}
	
	//to move one position upwards
	private int moveup(int mat[][], int row,int col){
		
		      return mat[row-1][col];
		
		
	}

	//to move one position downwards
	private int movedown(int mat[][], int row,int col){
	
			    return	mat[row+1][col];	
		
	}
	
	//to move one position rightwards
	private int moveright(int mat[][], int row,int col){
			
			  return mat[row][col+1];
			
		}
	

public int [] findmaxelement(int mat[][]){
	
	
	int arr[]=new int[3];
	int maxi = mat[0][0];
    for(int i = 0 ; i < mat.length ; ++i) {
        
        if(mat[i][0]>maxi){
        
        maxi=mat[i][0];	
        start_row_index=i;
		start_col_index=0;
        
        }
    }
  
	arr[0]=mat[start_row_index][start_col_index];
	arr[1]=start_row_index;
	arr[2]=start_col_index;
	
	return arr;
	
} 	
	
	
  public int traversePath(int mat[][],int m,int n){
	
	  
	  
	  if(flag==0){
	  int arr[]= findmaxelement(mat);
	  start_row_index=arr[1];
	  start_col_index=arr[2];
	  flag=1;
	  }
	  
	  
	  System.out.println("start_row index: "+start_row_index);
	  System.out.println("start col index: "+start_col_index);
	  
	  System.out.println("Start Element is: "+mat[start_row_index][start_col_index]);
	  
	  System.out.println();
	  
	  //mark as visited
	  visited[start_row_index][start_col_index]=true;
	  
	  
	 List<Integer> elementstoadd=new ArrayList<Integer>();
	 
	 
	 //adding start element:
	 elementstoadd.add(mat[start_row_index][start_col_index]);
	 
	 
	 
	 for(int i=0;i<mat.length;i++){
		 
		 for(int j=0;j<mat[i].length;j++){
			 
			 	  if(mat[i][j]!=-1){
			 		  
			 		 if(start_row_index==m-1){
						 
						 //cannot move down (array index out of bound exception)
						 
						 //move up
						 up=moveup(mat, start_row_index, start_col_index);
						 
						 
						 //move right
						 right=moveright(mat, start_row_index, start_col_index);
						 
						 
						 if(up>right){
							 
							 nextelement=up;
							 nextelement_row_index=start_row_index-1;
							 nextelement_col_index=start_col_index;
							 visited[nextelement_row_index][nextelement_col_index]=true;
						 }
						 else{
							 
							 nextelement=right;
							 nextelement_row_index=start_row_index;
							 nextelement_col_index=start_col_index+1;
							 visited[nextelement_row_index][nextelement_col_index]=true;
						 }
						 
						 
					 }//outer if
					 else if(start_row_index==0){
					
						 //cannot move up (array index out of bound exception)
						 
						 //move right
						 right=moveright(mat, start_row_index, start_col_index);
						 
						 
						 //move down
						 down=movedown(mat, start_row_index, start_col_index);
						 
						 
						 //select the Element with greater value and store its index
						 if(right>down){
							 
							 
							 nextelement=right;
							 nextelement_row_index=start_row_index;
							 nextelement_col_index=start_col_index+1;
							 visited[nextelement_row_index][nextelement_col_index]=true;
							 
						 }else{
							 
							 
							 nextelement=down;
							 nextelement_row_index=start_row_index+1;
							 nextelement_col_index=start_col_index;
							 visited[nextelement_row_index][nextelement_col_index]=true;
						 }
						 
						 	
						 
					 }//else if
					 else{
						 
						 //for rest of the element 
						 
						//can move up, down and right
						
						 //move up
						 up=moveup(mat, start_row_index, start_col_index);
						 
						 
						//move right
						 right=moveright(mat, start_row_index, start_col_index);
						 
						 
						 //move down
						 down=movedown(mat, start_row_index, start_col_index);
						 
						 
						 if(up>right){
							 
							 
							 nextelement=up;
							 nextelement_row_index=start_row_index-1;
							 nextelement_col_index=start_col_index;
							 
						 }else if(right>down){
							 
							 
							 nextelement=right;
							 nextelement_row_index=start_row_index;
							 nextelement_col_index=start_col_index+1;
							 
						 }else if(down>up){
							 
							 
							 nextelement=down;
							 nextelement_row_index=start_row_index+1;
							 nextelement_col_index=start_col_index;
						 
						 }
						 
						 visited[nextelement_row_index][nextelement_col_index]=true;
					 }
			
			 		  
			 	  }//if(mat[i][j]!=-1)
			 
		 }//j
	 }//i
	 
	 System.out.println("next Element to traverse: "+nextelement);
	 System.out.println("next Element row_index: "+nextelement_row_index);
	 System.out.println("next Element col index: "+nextelement_col_index);
	 
	 elementstoadd.add(nextelement);
	 
	 int sum= traversePathfornext(mat, nextelement_row_index, nextelement_col_index,visited,elementstoadd,m,n);
	 
	 return sum;
	 
	}
	 
  
  public int traversePathfornext(int mat[][], int start_row_index,int start_col_index,boolean visited[][],List<Integer> elist,int m,int n){
	
	  
	 for(int i=0;i<mat.length;i++){
		 
		 for(int j=0;j<mat[i].length;j++){

				 if(mat[i][j]!=-1){
					 
					 if(start_row_index==m-1){
						 
						 
						 
						 if(start_col_index==n-1){
							 
							//move up
							 up=moveup(mat, start_row_index, start_col_index);
							 
							 nextelement=up;
							 nextelement_row_index=start_row_index-1;
							 nextelement_col_index=start_col_index;
							 
							 visited[nextelement_row_index][nextelement_col_index]=true;
							 
							 
						 }else{
							 
							//cannot move down (array index out of bound exception)
							 
							 //move up
							 up=moveup(mat, start_row_index, start_col_index);
							 
							 
							 //move right
							 right=moveright(mat, start_row_index, start_col_index);
							 
							 
							 if(up>right && visited[start_row_index-1][start_col_index]==false){
								 
								 nextelement=up;
								 nextelement_row_index=start_row_index-1;
								 nextelement_col_index=start_col_index;
								 
								 visited[nextelement_row_index][nextelement_col_index]=true;
								 
							 }
							 else{
								  
								 nextelement=right;
								 nextelement_row_index=start_row_index;
								 nextelement_col_index=start_col_index+1;
								 
								 visited[nextelement_row_index][nextelement_col_index]=true;
								 
							 }
							 
						 }//else
						 
						 
					 }//outer if
					 else if(start_row_index==0){
					
						 //cannot move up (array index out of bound exception)
						 
						 //move right
						 right=moveright(mat, start_row_index, start_col_index);
						 
						 
						 //move down
						 down=movedown(mat, start_row_index, start_col_index);
						 
						 
						 if(right>down && visited[start_row_index][start_col_index+1]==false){
							  
							 nextelement=right;
							 nextelement_row_index=start_row_index;
							 nextelement_col_index=start_col_index+1;
						 
							 visited[nextelement_row_index][nextelement_col_index]=true;
							 
						 }else{
							 
							 
							 nextelement=down;
							 nextelement_row_index=start_row_index+1;
							 nextelement_col_index=start_col_index;
							 
							 visited[nextelement_row_index][nextelement_col_index]=true;
							 
						 }
						 
					 }else if(start_col_index==n-1){
							 
						 		    
							 		nextelement_row_index=start_row_index-1;
							 		nextelement_col_index=start_col_index;
							        nextelement=mat[nextelement_row_index][nextelement_col_index];
							        
							 		visited[nextelement_row_index][nextelement_col_index]=true;
						    	   
						       
					 }else if(start_row_index==0 && start_col_index==n-1 ){
						 		
						 		//top right corner element
						 		
						 		nextelement=mat[start_row_index][start_col_index];
						 		
						 		visited[start_row_index][start_col_index]=true;
						 
						 		System.out.println("Game finally ends here at:- "+nextelement);
						 		
						 		break;
						 
					 }else{
						 
						 	 //for rest of the element 
						 
							 //can move up, down and right
							
							 //move up
							 up=moveup(mat, start_row_index, start_col_index);
							 
							 
							 //move right
							 right=moveright(mat, start_row_index, start_col_index);
							 
							 
							 //move down
							 down=movedown(mat, start_row_index, start_col_index);
							 
							 
							 if( up>right  && visited[start_row_index-1][start_col_index]==false){

								 
								 nextelement=up;
								 nextelement_row_index=start_row_index-1;
								 nextelement_col_index=start_col_index;
								 visited[nextelement_row_index][nextelement_col_index]=true;
								 
							 }else if((right>down | down>right) && visited[start_row_index][start_col_index+1]==false){
								 
								 
								 nextelement=right;
								 nextelement_row_index=start_row_index;
								 nextelement_col_index=start_col_index+1;
								 visited[nextelement_row_index][nextelement_col_index]=true;
								 
							 }else if( down>up && visited[start_row_index+1][start_col_index]==false){
								 
								 nextelement=down;
								 nextelement_row_index=start_row_index+1;
								 nextelement_col_index=start_col_index;
								 visited[nextelement_row_index][nextelement_col_index]=true;
							 
							 }
						 
					 }
					 
										 
				 }//if(mat[i][j]!=-1)
				 				 			 
		 }//j
	 }//i
	 
	 
	 elist.add(nextelement);
	 
	 System.out.println("next Element to traverse: "+nextelement);
	 System.out.println("next Element row_index: "+nextelement_row_index);
	 System.out.println("next Element col index: "+nextelement_col_index);
	 System.out.println("");
	  
	//recursive call to same function:
	 try{
		 
		 traversePathfornext(mat, nextelement_row_index,nextelement_col_index,visited,elist,m,n);
		 
	 }catch(ArrayIndexOutOfBoundsException ex){
		 
		 System.out.println("!!!! Cannot move forward.....Game Over !!!!!: ");
		 
	 }
	
	int sum=0;
	
	for(int i: elist){
	
		sum=sum+i;	
	
	}
	
	return sum;
	  
  }

  
	public static void main(String[] args) {
	
		 int mat1[][] ={
				 
				    {-1, 4, 5, 1},
			        {2, -1, 2, 4},
			        {3, 3, -1, 3},
			        {4, 2, 1,  2},

		            };
		 
		 Main sg=new Main();
		 sg.printMatrix(mat1);
		
		 
		 int output=sg.traversePath(mat1, 4, 4);
		 
		 System.out.println("Output: "+output);
	}

}
