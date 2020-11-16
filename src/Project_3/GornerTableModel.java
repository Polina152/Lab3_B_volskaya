package Project_3;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel	{
	
	private Double[] coefficients;
	private Double from;
	private Double to;
	private Double step;
	private double result;
	private Boolean simmet;

	public GornerTableModel(Double from, Double to, Double step, Double[] coefficients)	{
		this.coefficients = coefficients;
		this.from = from;
		this.to = to;
		this.step = step;
	}
	
	public Double getFrom() {
		return from;
	}
	public Double getTo() {
		return to;
	}
	public Double getStep() {
		return step;
	}

	public int getColumnCount() {
		return 3;
	}
	@SuppressWarnings("deprecation")
	public int getRowCount() {
		return new Double(Math.ceil((to-from)/step)).intValue()+1;
	}
	public Object getValueAt(int row, int col) 	
	{
		double x = from + step*row;
		switch (col)
		{
		case 0:
			return x;
		case 1:
		{
			result = 0.0;
			for(int i = 0; i < coefficients.length; i++){
				result += Math.pow(x, coefficients.length-1-i)*coefficients[i];
				}
			return result;
			}
		default:
		{	
			simmet = false;
			int lev = (int)result%10;
			int prav = (int)(result*10)%10;
			if(lev == prav) simmet = true;
			return simmet;
		}
		}
	}
	  public Class<?> getColumnClass(int col) 
	  { 
		  if (col == 2) return Boolean.class;
		  else return Double.class; 
	  } 
	   
	  public String getColumnName(int col) {
		  
		  switch (col){
		  case 0:
			  return "Значение X";
		  case 1:
			  return "Значение многочлена";
		  default:
			  return "Ограниченная симметрия";
		  }
		  }	
	  }
