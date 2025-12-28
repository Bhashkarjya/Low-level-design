## Problem Statement: Real-Time Stock Price Alert System

Build a real-time stock price monitoring system for a trading platform.

### Context

1. The system tracks prices of multiple stocks (e.g., AAPL, GOGL, TSLA).
2. Stock prices are updated continuously from an external market feed.
3. Different parts of the system are interested in these updates:
   1. A Mobile App wants to show live prices. 
   2. A Trading Bot wants to place buy/sell orders when thresholds are crossed. 
   3. An Analytics Service wants to record price movements for later analysis.
4. These consumers should automatically react whenever a stock price changes.

