import { Product } from "./product";

export interface Warehouse {
    id: number;
    name: string;
    maxCapacity: number;
    products: Product[]
}