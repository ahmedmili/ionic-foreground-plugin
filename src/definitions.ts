export interface ForegroundPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
